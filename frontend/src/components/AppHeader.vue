<template>
	<div class="header">
		<header>
		<div class="navigation__buttons">
			<a class="navigation__element" href=""><h4>Помощь </h4></a>
			<a class="navigation__element" href=""><h4>FAQ </h4></a>
		</div>
		<div class="logo">
			<img src="/imgs/logoMainPage.svg" alt="logo">
		</div>
		<div class="navigation__buttons">
			<button class="navigation__element caption navigation__action__element" @click="$router.push('/login')"><img src="/imgs/userIcon.png" alt="">ВОЙТИ </button>
			<button class="navigation__element caption navigation__action__element"><img src="/imgs/favoriteIcon.png" alt="">ИЗБРАННОЕ </button>
			<button class="navigation__element caption navigation__action__element"><img src="/imgs/cartIcon.png" alt="">КОРЗИНА </button>
		</div>
		
	</header>
	<div class="category__list__header">
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'guitars' }}">Гитары</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'strings' }}">Гитарные струны</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'pedals' }}">Педали</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'keyboards' }}">Клавишные</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'headphones' }}">Наушники</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'switchs' }}">Коммутация</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'microphones' }}">Микрофоны</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'ateliers' }}">Студия</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'accessories' }}">Аксессуары</router-link></div>
			<div class="item__category"><router-link :to="{ name: 'CatalogPage', query: { category: 'cases' }}">Чехлы и кейсы</router-link></div>
			<div class="item__category "><router-link :to="{ name: 'CatalogPage', query: { category: 'sale' }}" class="sale_item">Распродажа</router-link></div>
		</div>
	</div>
	
</template>
<script>
export default{
}
</script>

<style scoped src="@/assets/css/header.css">
</style>