import { createRouter, createWebHistory } from 'vue-router'

import MainPage from "@/pages/MainPage.vue"
import CatalogPage from '@/pages/CatalogPage.vue'
import PersonalAccountPageVue from '@/pages/PersonalAccountPage.vue'

const routes = [
	{
		path: '/',
		name:'MainPage',
		component: MainPage
	},
	{
		path:'/catalog',
		name:'CatalogPage',
		component: CatalogPage
	},
	{
		path:'/account',
		name:'CatalogPage',
		component: PersonalAccountPageVue
	},


]




const router = createRouter({
	routes,
	history: createWebHistory()
})
export default router;