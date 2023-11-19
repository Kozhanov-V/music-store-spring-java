<template>
	<div class="header">
		<header>
		<div class="navigation__buttons">
			<a class="navigation__element" href=""><h4>Помощь </h4></a>
			<a class="navigation__element" href=""><h4>Блог </h4></a>
			<a class="navigation__element" href=""><h4>FAQ </h4></a>
		</div>
		<div class="logo">
			<img src="/imgs/logoMainPage.svg" alt="logo">
		</div>
		<div class="navigation__buttons">
			<button class="navigation__element caption navigation__action__element" @click="$router.push('/login')"><img src="/imgs/userIcon.png" alt="">ВОЙТИ </button>
			<button class="navigation__element caption navigation__action__element"><img src="/imgs/favoriteIcon.png" alt="">ИЗБРАННОЕ </button>
			<button class="navigation__element caption navigation__action__element"><img src="/imgs/cartIcon.png" alt="">КОРЗИНА </button>
			<button class="navigation__element caption navigation__action__element"><img src="/imgs/searchIcon.png" alt="">ПОИСК </button>
		</div>
		
	</header>
	<div class="category__list__header">
			<div class="item__category"><a href="">Новинки</a></div>
			<div class="item__category"><a href="">Гитары</a></div>
			<div class="item__category"><a href="">Гитарные струны</a></div>
			<div class="item__category"><a href="">Педали</a></div>
			<div class="item__category"><a href="">Клавишные</a></div>
			<div class="item__category"><a href="">Наушники</a></div>
			<div class="item__category"><a href="">Коммутация</a></div>
			<div class="item__category"><a href="">Микрофоны</a></div>
			<div class="item__category"><a href="">Студия</a></div>
			<div class="item__category"><a href="">Аксессуары</a></div>
			<div class="item__category"><a href="">Чехлы и кейсы</a></div>
			<div class="item__category"><a href="" class="sale_item">Распродажа</a></div>
		</div>
	</div>
	
</template>
<script>

export default{

}
</script>

<style scoped>
.header{
	position: relative;
	margin-bottom: 50px;
	width: 100%;
}


header{
	width: 1360px;
	height: 100px;
  display: flex;
  justify-content: space-between;
	align-items: center;
	display: flex;
    margin-left: auto;
    margin-right: auto
}
.navigation__element{
	margin-right: 25px;
}

.navigation__action__element{
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	background: none;
	border: none;

	color: transparent; /* Сделаем текст прозрачным для начала */
  background-clip: text;
  -webkit-background-clip: text;

}

.navigation__action__element {
  background-image: linear-gradient(to right, grey, grey);
}

/* Изменяем градиент на черный при наведении */
.navigation__action__element:hover {
  background-image: linear-gradient(to right, black, black);
}

/* Применяем серый фильтр к изображениям */
.navigation__action__element img {
  filter: grayscale(100%);
  transition: filter 0.3s; /* Плавное изменение фильтра */
}

/* Убираем серый фильтр при наведении */
.navigation__action__element:hover img {
  filter: grayscale(0%);
}


.navigation__action__element *{
	margin-left: auto;
    margin-right: auto;
		margin-bottom: 5px;
}
.navigation__buttons{
	display: flex;
	justify-content: flex-start;
}



.logo {
}

.category__list__header{
	margin-top: 15px;
	width: 1360px;
	display: flex;
    margin-left: auto;
    margin-right: auto
}
.item__category{
	margin-right: 25px;
	font-size: 14px;
}

.category__list__header .item__category a {
    color: black;
		transition: color 0.3s;
}

/* При наведении на любой элемент в .category__list__header, все ссылки становятся серыми */
.category__list__header:hover .item__category a {

    color: grey;
}

/* Но элемент, на который наведен курсор, остается черным */
.category__list__header .item__category a:hover {

    color: black;
}

.category__list__header .item__category .sale_item{
color: #EB5757;
}
.category__list__header .item__category .sale_item:hover{
color: red;
}
</style>