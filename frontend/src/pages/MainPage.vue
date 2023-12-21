<template>
	<div>
		<div class="main__slaider">
			<ImageSlidertwo :images="images" width="1360px" height="500px" countItem=1>

			</ImageSlidertwo>
		</div>
		<div class="slider__companies">
			<ImageSlidertwo :images="logoCompanies" width="100%" height="61px" countItem=12></ImageSlidertwo>
		</div>

		<div class="promotions">
			<a href="">
				<div class="promotion">
					<img src="/imgs/promotion1.png" alt="" height="269" width="667">
					<h3>НАЗВАНИЕ АКЦИИ №1</h3>
				</div>
			</a>
			<a href="">
				<div class="promotion">
					<img src="/imgs/promotion2.png" alt="" height="269" width="667">
					<h3>НАЗВАНИЕ АКЦИИ №2</h3>
				</div>
			</a>
		</div>

		<div class="container__second__block">
			<h2>Новинки</h2>
			<div class="new__items__container">
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem1.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem2.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem1.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem3.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem3.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
			</div>

			<button>
				<h4>Показать больше</h4>
			</button>
		</div>
		<div class="third__block__container">
			<img src="/imgs/deliveryMainPage.png" alt="" height="400" width="1360">
			<h3>Доставка по параллельному импорту</h3>
			<p>Доставка по параллельному импорту Доставка по параллельному импорту Доставка по параллельному импорту Доставка по
				параллельному импорту Доставка по параллельному импорту Доставка по параллельному импорту Доставка по
				параллельному импорту Доставка по параллельному импорту Доставка по параллельному импорту Доставка по
				параллельному импорту Доставка по параллельному импорту </p>
		</div>

		<div class="container__second__block">
			<h2>Tomann популярное в категории</h2>
			<div class="new__items__container">
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem1.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem2.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem1.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem3.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
				<a href="">
					<div class="new__item">
						<img src="/imgs/logoItem3.png" alt="" height="270" width="270">
						<span class="new__item__information">
							<h4>NAME ITEM</h4>
							<p>Категория</p>
							<h4>price</h4>
						</span>
					</div>
				</a>
			</div>

			<button>
				<h4>Показать больше</h4>
			</button>
		</div>

		<div class="container__four__block">
			<div class="promotion__four_block" id="promotion__four_block_1">
				<div class="container__info__of__promotion">
					<img src="/imgs/logoInPromotion.png" alt="">
					<h2>Программа лояльности</h2>
					<h4>Зарабатывайте баллы и получайте преимущества</h4>
					<button>Вступить в клуб</button>
				</div>
			</div>
			<div class="promotion__four_block" id="promotion__four_block_2">
				<div class="container__info__of__promotion">
					<img src="/imgs/mailLogo.png" alt="">
					<h2>Скидка -5%</h2>
					<h4>По реферальной ссылке от друзей</h4>
					<button>Получить промокод для друзей</button>
				</div>
			</div>
		</div>
		</div>
</template>

<script>
import ImageSlidertwo from "@/components/ImageSlidertwo.vue"

export default {

	components: {
		ImageSlidertwo,
	},
	data() {
		return {
			images: [
				{ src: '/imgs/action1.jpg', url: '/' },
				{ src: '/imgs/action2.png', url: '/' },
				{ src: '/imgs/action3.png', url: '/' }
			],
			logoCompanies: [
				{ src: '/imgs/logoCompany.png', url: '/' },
				{ src: '/imgs/logoCompany.png', url: '/' },
				{ src: '/imgs/logoCompany2.png', url: '/' },
				{ src: '/imgs/logoCompany3.png', url: '/' },
				{ src: '/imgs/logoCompany4.png', url: '/' },
				{ src: '/imgs/logoCompany.png', url: '/' },
				{ src: '/imgs/logoCompany2.png', url: '/' },
				{ src: '/imgs/logoCompany3.png', url: '/' },
				{ src: '/imgs/logoCompany4.png', url: '/' },
				{ src: '/imgs/logoCompany.png', url: '/' },
				{ src: '/imgs/logoCompany2.png', url: '/' },
				{ src: '/imgs/logoCompany3.png', url: '/' },
				{ src: '/imgs/logoCompany4.png', url: '/' }
			]
		};
	}
}
</script>
<style scoped>
.slider__companies {
	margin-top: 60px;
	width: 1360px;
	margin-left: auto;
	margin-right: auto;
	display: flex;
	justify-content: flex-start;
	margin-bottom: 60px;
}

.promotion h3 {
	margin-top: -3px;
	width: 667px;
	height: 70px;
	background-color: black;
	color: white;
	display: flex;
	align-items: center;
	justify-content: center;
}

.promotions {
	display: flex;
	width: 1360px;
	margin-left: auto;
	margin-right: auto;

}

.promotion {
	margin-right: 25px;
}

.container__second__block {
	margin-top: 100px;
	width: 1360px;
	margin-left: auto;
	margin-right: auto;
}

.container__second__block h2 {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 50px;
}

.container__second__block button {
	width: 320px;
	height: 50px;
	display: flex;
	margin-left: auto;
	margin-right: auto;
	align-items: center;
	justify-content: center;
	margin-top: 75px;
	background-color: black;
	color: white;
	cursor: pointer;
}

.new__items__container {
	display: flex;
	width: 100%;
	margin-left: auto;
	margin-right: auto;
}


.new__item {
	margin-right: 25px;
}

.new__item img {
	margin-bottom: 55px;
}

.new__item * {
	margin-bottom: 5px;
}

.third__block__container {
	margin-top: 100px;
	width: 1360px;
	margin-left: auto;
	margin-right: auto;
}

.third__block__container h3 {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-top: 25px;
}

.third__block__container p {
	text-align: justify;
	margin-top: 10px;
}

.container__four__block {
	margin-left: auto;
	margin-right: auto;
	width: 1360px;
	display: flex;
	margin-top: 100px;
}

.promotion__four_block {
	display: flex;
	width: 668px;
	height: 789px;
	background-repeat: no-repeat;
	background-size: cover; /* Заставляет изображение заполнять весь блок */
	background-position: center; /* Центрирует изображение */
	color: white;
	align-items: center;
	justify-content: center;
	position: relative;
	margin-right: 25px;
}
.promotion__four_block * {
text-align: center;
margin-top: 25px;
}
.promotion__four_block h4{
	margin-top: 15px;
}

#promotion__four_block_1 button{
	width: 292px;
	height: 50px;
	border: none;
	cursor: pointer;
	font-size: 16px;

}

#promotion__four_block_2 button{
	width: 401px;
	height: 50px;
	border: none;
	cursor: pointer;
	font-size: 16px;

}


.promotion__four_block::before {
	content: ''; 
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: rgba(0, 0, 0, 0.35); 
	z-index: 1; 
}

.container__info__of__promotion {
	z-index: 2; /* Убедитесь, что текст и элементы поверх фильтра */
	position: relative;
}

#promotion__four_block_1 {
	background-image: url('C:\Users\vkozh\Documents\GitHub\music-store-spring-java\frontend\public\imgs\promotionFour1.jpg');
}
#promotion__four_block_2 {
background-image: url('C:\Users\vkozh\Documents\GitHub\music-store-spring-java\frontend\public\imgs\promotionFour2.jpg');
}</style>