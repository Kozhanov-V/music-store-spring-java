<template>
	<div class="container__catalog">


		<div class="filter__btns">
			<h2>{{ this.category }}</h2>
			<div class="sort__by">
				<p>Сортировать по:</p>
				<select name="sort__select" id="sort__select">
					<option value="">СНАЧАЛА НЕДОРОГИЕ</option>
					<option value="">CНАЧАЛА ДОРОГИЕ</option>
					<option value="">СНАЧАЛА ПОПУЛЯРНЫЕ</option>
					<option value="">ПО СКИДКИ(%)</option>
				</select>
			</div>
		</div>

		<div class="container__second__block">
			<div class="categories">
				<h4>Бренды товаров</h4>
				<ul class="categories__list">
					<li v-for="brand in brands" :key="brand.id">
						<label class="custom-checkbox">
							<input type="checkbox" :value="brand.name" v-model="filtersParam.listBrands" :id="brand.id"
								class="custom-checkbox-input">
							<span class="custom-checkbox-box"></span>
							<span class="custom-checkbox-name">{{ brand.name }}</span>
							<span class="custom-checkbox-count"> {{ brand.count }}</span>
						</label>
					</li>
				</ul>
				<h4>Смотреть</h4>
				<ul>
					<li v-for="category in salesCategories" :key="category.name">
						<label class="custom-radio">
							<input type="radio" :value="category.value" v-model="filtersParam.withDiscount" :id="category.name"
								class="custom-radio-input" :checked="category.name === salesCategories[0].name">
							<span class="custom-radio-box"></span>
							<span class="custom-radio-name">{{ category.name }}</span>
							<span class="custom-radio-count">{{ category.count }}</span>
						</label>
					</li>
				</ul>
				<h4>Цена, ₽ </h4>
				<nouiSlide @update-price="handleUpdatePrice" />
				<div v-for=" attribute in attributesCategory" :key="attribute.name">
					<filterComponentVue :name="attribute.name" :attributesList="attribute.attributes"
						@update-attributes="handleUpdateAttributes" />
				</div>
				<button class="categories__btn__accept" @click="fetchItemsByFilterParams()">
					Применить
				</button>
				<button class="categories__btn__reset">
					Сбросить
				</button>
			</div>

			<div class="catalog__items">
				<a href="" v-for="item in items" :key="item.id">
					<div class="product">
						<div class="product-image">
							<img :src="item.imageUrl" :alt="item.name" height="270" style="max-width: 270px;">
							<span class="product-discount" v-if="item.discount > 0">-{{ item.discount }}%</span>
						</div>
						<div class="product-details">
							<h4>{{ item.name }}</h4>
							<p>{{ item.brand }}</p>
							<div class="product-price">
								<span class="original-price" v-if="item.discount > 0">{{ item.price
								}}P</span>
								<span :class="{ 'final-price': true, 'discounted': item.discount > 0 }">
									{{ calculateFinalPrice(item.price, item.discount) }}P
								</span>
							</div>
						</div>
					</div>
				</a>

			</div>
		</div>

	</div>
</template>
<script>
import nouiSlide from '@/components/nouiSlide.vue';
import axios from 'axios';
import filterComponentVue from '@/components/FilterComponent.vue'
export default {
	components: {
		nouiSlide,
		filterComponentVue,
	},
	data() {
		return {
			category: null,
			attributesCategory: [],
			selectedCategorySales: '',
			salesCategories: [
				{ name: 'Все товары', value: false },
				{ name: 'Только со скидкой', value: true },
			],
			items: [],
			brands: [],
			filtersParam: {
				listBrands: [],
				minPrice: '',
				maxPrice: '',
				withDiscount: false,
				attributes: {}

			}
		};
	},
	methods: {
		calculateOriginalPrice(price, discount) {
			return discount > 0 ? (price / (1 - discount / 100)).toFixed(2) : price;
		},
		calculateFinalPrice(price, discount) {
			return discount > 0 ? (price - (price * discount / 100)).toFixed(2) : price;
		},
		selectCategory(name) {
			this.selectedCategory = name;
		},
		handleUpdatePrice(priceData) {
			this.filtersParam.minPrice = priceData.min;
			this.filtersParam.maxPrice = priceData.max;
		},
		handleUpdateAttributes(updatedAttributes) {

			for (const [key, value] of Object.entries(updatedAttributes)) {
				console.log(key + "   " + value);
				this.filtersParam.attributes[key] = value;
			}
		},
		async fetchItemsByFilterParams() {
			try {
				this.filtersParam.minPrice = this.filtersParam.minPrice.replace(/\D/g, '');
				this.filtersParam.maxPrice = this.filtersParam.maxPrice.replace(/\D/g, '');

				const attributesParam = JSON.stringify(this.filtersParam.attributes);
				console.log(attributesParam)
				const response = await axios.get(`http://localhost:8080/api/items/filter?category=${this.category}&listBrands=${this.filtersParam.listBrands}&minPrice=${this.filtersParam.minPrice}&maxPrice=${this.filtersParam.maxPrice}&withDiscount=${this.filtersParam.withDiscount}&attributes=${encodeURIComponent(attributesParam)}`);
			
				this.items = response.data.map(element => ({
					id: element.productId,
					imageUrl: element.urlOnImg,
					brand: element.brand.name,
					name: element.name,
					price: element.price,
					discount: element.discounts,
			
			}));
			
			} catch (e) {
				console.log('Ошибка при поиске по категории');
			}
		},
		async fetchFilterCategories(category) {
			try {
				const response = await axios.get(`http://localhost:8080/api/attributes/category/${category}`);

				this.attributesCategory = Object.keys(response.data).map(key => ({
					name: key,
					attributes: response.data[key]
				}));

			} catch (e) {
				console.log('Ошибка при поиске по категории')
			}
		},
		async fetchItemsByCategory(category) {
			try {
				const response = await axios.get(`http://localhost:8080/api/items/category/${category}`);
				console.log(response)
				this.items = response.data.map(element => ({
					id: element.productId,
					imageUrl: element.urlOnImg,
					brand: element.brand.name,
					name: element.name,
					price: element.price,
					discount: element.discounts,
				}));
				console.log(this.items)
			} catch (e) {
				alert('Ошибка при загрузке товаров');
			}
		},
		async fetchBrandsByCategory(category) {
			try {
				const response = await axios.get(`http://localhost:8080/api/brands/category/${category}`);
				this.brands = response.data.map(element => ({
					id: element.brandId,
					name: element.name,
					information: element.information
				}));

			} catch (e) {
				alert('Ошибка при выборке брендов');
			}
		},


	},
	watch: {
		'$route.query.category': {
			immediate: true,
			handler(newCategory) {
				console.log('New category:', newCategory);
				this.category = newCategory;
				this.fetchFilterCategories(this.category);
				this.fetchItemsByCategory(this.category);
				this.fetchBrandsByCategory(this.category);
			}
		}
	},
	mounted() {
		console.log('qqqq')
		this.fetchFilterCategories();
	}



}
</script>

<style scoped src="@/assets/css/catalogPage.css">

</style>