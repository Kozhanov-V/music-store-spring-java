<template>
<div class="container__account">
	<h2>Мой аккаунт</h2>
	<div class="container__btns">
		<button 
      v-for="tab in tabs" 
      :key="tab.component"
      :class="{ active_btn: activeTab === tab.component }"
      @click="activeTab = tab.component"
    >
      {{ tab.name }}
    </button>
		<div  v-if="activeTab === 'AccountMainComponent'"><AccountMainComponent/></div>
		<div v-if="activeTab === 'AccountOrdersComponent'"><AccountOrdersComponent/></div>
		<div v-if="activeTab === 'AccountBonusComponent'"><AccountBonusComponent/></div>
		<div  v-if="activeTab === 'AccountPersonalInformationComponent'"><AccountPersonalInformationComponent/></div>
		<div v-if="activeTab === 'AccountAddressComponent'"><AccountAddressComponent/></div>
	</div>

</div>
</template>
<script>
import AccountAddressComponent from '@/components/AccountAddressComponent.vue';
import AccountBonusComponent from '@/components/AccountBonusComponent.vue';
import AccountMainComponent from '@/components/AccountMainComponent.vue';
import AccountOrdersComponent from '@/components/AccountOrdersComponent.vue';
import AccountPersonalInformationComponent from '@/components/AccountPersonalInformationComponent.vue';

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
    };
  },
};
</script>

<style>
.active_btn{
	background-color: black;
	color: white;
	widows: 150px;

	height: 50px;
}
</style>