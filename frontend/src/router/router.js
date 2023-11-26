import { createRouter, createWebHistory } from 'vue-router'

import MainPage from "@/pages/MainPage.vue"
import CatalogPage from '@/components/CatalogPage.vue'

const routes = [
	{
		path: '/',
		component: MainPage
	},
	{
		path:'/catalog',
		component: CatalogPage
	}
]
const router = createRouter({
	routes,
	history: createWebHistory(process.env.BASE_URL)
})
export default router;