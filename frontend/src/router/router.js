import { createRouter, createWebHistory } from 'vue-router'

import MainPage from "@/pages/MainPage.vue"
import CatalogPage from '@/pages/CatalogPage.vue'

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
]
const router = createRouter({
	routes,
	history: createWebHistory()
})
export default router;