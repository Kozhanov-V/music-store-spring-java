<template>
	<div class="container__catalog">


		<div class="filter__btns">
			<h2>Название Категории</h2>
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
					<li v-for="category in categories" :key="category.name">
						<label class="custom-checkbox">
							<input type="checkbox" :value="category.name" v-model="selectedCategories" :id="category.name"
								class="custom-checkbox-input">
							<span class="custom-checkbox-box"></span>
							<span class="custom-checkbox-name">{{ category.name }}</span>
							<span class="custom-checkbox-count"> {{ category.count }}</span>
						</label>
					</li>
				</ul>
				<h4>Смотреть</h4>
				<ul>
					<li v-for="category in salesCategories" :key="category.name">
						<label class="custom-radio">
							<input type="radio" :value="category.name" v-model="selectedCategorySales" :id="category.name"
								class="custom-radio-input" :checked="category.name === salesCategories[0].name">
							<span class="custom-radio-box"></span>
							<span class="custom-radio-name">{{ category.name }}</span>
							<span class="custom-radio-count">{{ category.count }}</span>
						</label>
					</li>
				</ul>
				<h4>Цена, ₽ </h4>
				<nouiSlide />
				<div v-for=" attribute in attributesCategory" :key="attribute.name">
					<filterComponentVue :name="attribute.name" :attributesList="attribute.attributes" />
				</div>
				<button class="categories__btn__accept">
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
							<img :src="item.imageUrl" :alt="item.name">
							<span class="product-discount" v-if="item.discount > 0">-{{ item.discount }}%</span>
						</div>
						<div class="product-details">
							<h4>{{ item.brand }}</h4>
							<p>{{ item.category }}</p>
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
				{ name: 'Все товары', count: 368 },
				{ name: 'Только со скидкой', count: 48 },
			],
			items: [
				{
					id: 1,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '50',
				}, {
					id: 2,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '50',
				}, {
					id: 3,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '50',
				}, {
					id: 4,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '10',
				}, {
					id: 5,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '50',
				}, {
					id: 6,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '50',
				}, {
					id: 7,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '50',
				}, {
					id: 8,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '34392',
					discount: '0',
				}, {
					id: 9,
					imageUrl: '/imgs/LibTechLogo.png',
					category: 'Snowboard',
					brand: 'LIB TECH',
					price: '21000',
					discount: '10',
				}
			],
			selectedCategories: [],
			categories: [
				{ name: 'Сноуборды', count: 24 },
				{ name: 'Крепления', count: 48 },
				{ name: 'Обувь', count: 60 },
				{ name: 'Обувь2', count: 61 },
				{ name: 'Обувь3', count: 62 },
				{ name: 'Обувь4', count: 63 },
				{ name: 'Обувь5', count: 64 },
			]
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
		async fetchFilterCategories(category) {
			try {
				const response = await axios.get(`http://localhost:8080/api/attributes/category/${category}`);
				this.attributesCategory = response.data;

				this.attributesCategory = Object.keys(response.data).map(key => ({
            name: key,
            attributes: response.data[key]
        }));

			} catch (e) {
				alert('Ошибка');
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
            }
        }
    },
	mounted() {
		this.fetchFilterCategories();
	}



}
</script>

<style>
.container__catalog {
	width: 1360px;
	position: relative;
	margin-left: auto;
	margin-right: auto;
}

.filter__btns {
	display: flex;
	margin-top: 25px;
	width: 100%;
	justify-content: space-between;
}

.sort__by {
	display: flex;
	align-items: center;
	position: relative,


}

.sort__by p {
	margin-right: 15px;


}

.sort__by select {
	width: 320px;
	height: 50px;
	font-family: GrtskPeta-Medium;
	padding: 15px;
	font-size: 12px;
	border: none;
	background-color: #F9F9F9;
}

.container__second__block {
	margin-top: 25px;
	display: flex;
}




.catalog__items {
	display: flex;
	flex-wrap: wrap;
	gap: 25px;


}

.product {
	margin-top: 25px;
	width: 321px;
}

.product-details {
	margin-top: 10px;
}

.product-details p {
	margin-top: 5px;
}

.product-image {
	position: relative;
	background-color: #F9F9F9;
	width: 320px;
	height: 370px;
}

.product-image img {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%)
}

.product-discount {
	position: absolute;
	top: 0;
	right: 0;
	background-color: #EB5757;
	color: white;
	padding: 5px;
}

.product-details {
	text-align: left;

}

.product-price {
	margin-top: 10px;
}

.original-price {
	text-decoration: line-through;
	/* Зачеркивание для старой цены */
	color: #A5A5A5;
	margin-right: 15px;
	font-family: GrtskPeta-Medium;
	font-size: 18px;
	/* Серый цвет для старой цены, если хотите сделать его менее заметным */
}

.final-price {
	color: #EB5757;
	font-family: GrtskPeta-Medium;
	font-size: 18px;
}

/* Стиль для цены без скидки */
.product-price .final-price:not(.discounted) {
	color: black;
	/* Белый или другой цвет по умолчанию для цены без скидки */
}

.product-add-to-cart {
	position: absolute;
	top: 10px;
	right: 10px;
	background-color: black;
	color: white;
	border: none;
	cursor: pointer;
}

.categories {
	position: relative;
	width: 295px;
	margin-right: 50px;
}

.categories h4 {
	margin-bottom: 20px;
	margin-top: 40px;
}

.categories ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.categories li {
	display: flex;
	align-items: center;
	padding: 7.5px 0;
}

.categories input[type="checkbox"],
.categories input[type="radio"] {
	margin-right: 10px;
	cursor: pointer;
	color: #EB5757;
}


.categories label {
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 100%;
	cursor: pointer;
}

.categories label span:last-child {
	margin-left: auto;
}

.categories .categories__btn__accept {
	margin-top: 40px;
	background-color: black;
}

.categories .categories__btn__reset {
	margin-top: 20px;
	background-color: white;
	color: black;
}

.categories button {
	width: 300px;
	height: 50px;
	display: flex;
	margin-left: auto;
	margin-right: auto;
	align-items: center;
	justify-content: center;

	color: white;
	cursor: pointer;
	font-size: 16px;
	font-family: GrtskPeta-Medium;
}



.custom-checkbox-box,
.custom-radio-box {
	position: relative;
	display: inline-block;
	width: 16px;
	height: 16px;
	background-color: #ffffff;
	border: 1px solid black;
	border-radius: 50%;
	margin-right: 10px;
	vertical-align: sub;
}

.custom-checkbox-box::before,
.custom-radio-box::before {
	content: '';

	display: inline-block;
	width: 100%;
	height: 100%;
	background-color: #EB5757;
	background-image: url('@/assets/imgs/checkedCheckBox.svg');
	background-position: center;
	background-repeat: no-repeat;
	border-radius: 50%;
	background-size: contain;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%) scale(0);
	border: 1px solid #EB5757;
	transition: 0.1s ease-in-out;
}

.custom-checkbox-input,
.custom-radio-input {
	width: 0;
	height: 0;
	opacity: 0;
	position: absolute;
	z-index: -1;
}

.custom-checkbox-count,
.custom-radio-count {
	color: grey;
}

.custom-checkbox-input:checked+.custom-checkbox-box::before,
.custom-radio-input:checked+.custom-radio-box::before {
	transform: translate(-50%, -50%) scale(1.05);
}

.custom-checkbox-input:checked~.custom-checkbox-count,
.custom-radio-input:checked~.custom-radio-count {
	color: black;
	transition: 0.2s;
}

.custom-checkbox-input:checked~.custom-checkbox-name,
.custom-radio-input:checked~.custom-radio-name {
	color: #EB5757;
	transition: 0.2s;
}
</style>