<template>
	<div class="container__blocks__account">
		<div class="block__account">
			<div class="header__block__account">
				<h3>Корзина <span>кол-во товаров</span></h3>
				<a class="caption">Перейти в корзину</a>
			</div>
			<div class="body__block__account">
				<ol>
					<li>Гибсон</li>
					<li>Гибсон</li>
					<li>Гибсон</li>
					<li>Гибсон</li>
					<li>Гибсон</li>
					<p>И еще 9 товаров на общую сумму: <span class="price__basket">3200 ₽</span></p>
				</ol>
			</div>
		</div>
		<div class="block__account">
			<div class="header__block__account">
				<h3>Бонусный счет </h3>
				<a class="caption">Отвязать карту</a>
			</div>
			<div class="body__block__account">
				<div class="about__bonus__account">
					<p><span>Вам доступно для погашения </span> 30% от стоимости заказа</p>
					<img src="/imgs/logoMainPage.svg" alt="">
				</div>
				<h2>КОЛ-ВО баллов</h2>
				<p><span>баллов на вашем счету</span></p>
			</div>
		</div>
		<div class="block__account">
			<div class="header__block__account">
				<h3>Заказы </h3>
				<a class="caption">Все заказы</a>
			</div>
			<div class="body__block__account">
				<table>
					<tr>
						<th>195455-222546-ANU</th>
						<th><img src="" alt="">Заказ передан в службу доставки</th>
						<th> 1 118 570 ₽</th>
					</tr>
					<tr>
						<th>195455-222546-ANU</th>
						<th><img src="" alt="">Заказ передан в службу доставки</th>
						<th> 1 118 570 ₽</th>
					</tr>
					<tr>
						<th>195455-222546-ANU</th>
						<th><img src="" alt="">Отменен</th>
						<th> 1 118 570 ₽</th>
					</tr>
					<tr>
						<th>195455-222546-ANU</th>
						<th><img src="" alt="">Возврат</th>
						<th> 1 118 570 ₽</th>
					</tr>
					<tr>
						<th>195455-222546-ANU</th>
						<th><img src="" alt="">Заказ передан в службу доставки</th>
						<th> 1 118 570 ₽</th>
					</tr>

				</table>
			</div>
		</div>
		<div class="block__account">
			<div class="header__block__account">
				<h3>Избранное </h3>
				<a class="caption">Перейти в избранное</a>
			</div>
			<div class="body__block__account">

				<div class="catalog__items">
					<a href="" v-for="item in items" :key="item.id">
						<div class="product">
							<div class="product-image">
								<img :src="item.imageUrl" :alt="item.name" height="207" style="max-width: 179px;">
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
		<div class="block__account">
			<div class="header__block__account">
				<h3>Личная информация</h3>
				<a class="caption">Редактировать</a>
			</div>
			<div class="body__block__account personal__info">
				<div>
					<p>Иванов Иван Иванович</p>
					<p>мужчина</p>
					<p>15.10.1988</p>
					<p>+7 (950) 145 22 55</p>
					<p>ivanov@gmail.com</p>
				</div>
				<div>
					<p>Пароль: ********</p>
				</div>
			</div>
		</div>
	</div>
</template>
<script>

export default {
	data() {
		return {
		}
	},
	props: {
    items: Array
  },
	methods: {
		calculateFinalPrice(price, discount) {
			return discount > 0 ? (price - (price * discount / 100)).toFixed(2) : price;
		},
	
	}
}
</script>
<style scoped src="@/assets/css/accountMainComponent.css">
</style>