<template>
	<div class="container__account">
		<h2>Мой аккаунт</h2>
		<div class="container__btns">
			<button v-for="tab in tabs" :key="tab.component" :class="{ active_btn: activeTab === tab.component }"
				@click="activeTab = tab.component">
				{{ tab.name }}
			</button>
	
		</div>
		<div v-if="activeTab === 'AccountMainComponent'">
				<AccountMainComponent  :items="items" />
			</div>
			<div v-if="activeTab === 'AccountOrdersComponent'">
				<AccountOrdersComponent />
			</div>
			<div v-if="activeTab === 'AccountBonusComponent'">
				<AccountBonusComponent />
			</div>
			<div v-if="activeTab === 'AccountPersonalInformationComponent'">
				<AccountPersonalInformationComponent />
			</div>
			<div v-if="activeTab === 'AccountAddressComponent'">
				<AccountAddressComponent />
			</div>
	</div>
</template>
<script>
import AccountAddressComponent from '@/components/AccountAddressComponent.vue';
import AccountBonusComponent from '@/components/AccountBonusComponent.vue';
import AccountMainComponent from '@/components/AccountMainComponent.vue';
import AccountOrdersComponent from '@/components/AccountOrdersComponent.vue';
import AccountPersonalInformationComponent from '@/components/AccountPersonalInformationComponent.vue';
import axios from 'axios';
export default {

	components: {
		AccountAddressComponent,
		AccountBonusComponent,
		AccountMainComponent,
		AccountOrdersComponent,
		AccountPersonalInformationComponent,
	},

	data() {
		return {
			activeTab: 'AccountMainComponent',
			tabs: [
				{ name: 'Главная', component: 'AccountMainComponent' },
				{ name: 'Мои заказы', component: 'AccountOrdersComponent' },
				{ name: 'Бонусный счет', component: 'AccountBonusComponent' },
				{ name: 'Личная информация', component: 'AccountPersonalInformationComponent' },
				{ name: 'Мои адреса', component: 'AccountAddressComponent' },
			],
			items:[],
		}
	},
	methods: {
		async fetchItemsByCategory() {
			try {
				const response = await axios.get(`http://localhost:8080/api/items/user/1`);
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
	},
	mounted(){
		this.fetchItemsByCategory();
	}

};
</script>

<style scoped src="@/assets/css/personalAccountPage.css"></style>