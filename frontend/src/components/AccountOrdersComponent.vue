<template>
  <div>
    <table>
      <tbody>
        <template v-for="(order, index) in orders" :key="order.id">
          <tr @click="toggleDetails(index)">
            <td colspan="2">
              <img v-if="selectedOrderIndex === index" src="/imgs/minusInCircle.png" alt="Скрыть">
              <img v-else src="/imgs/plusInCircle.png" alt="Показать">
              Подробности
            </td>
            <td colspan="2">{{ order.numberOrder }}</td>
            <td colspan="2">{{ order.statusOrder }}</td>
            <td colspan="2">{{ order.price }}</td>
          </tr>
          <tr v-if="selectedOrderIndex === index" class="order-details">
            <td colspan="2">
              <p>Статус: </p>
              <p>Способ доставки: </p>
              <p>Дата оформления заказа:</p>
              <p>Телефон:</p>
              <p>Адрес доставки: </p>
            </td>
						<td colspan="2">
						<p>	{{ order.statusOrder }}</p>
						<p>	{{ order.deliveryMethod }}</p>
						<p>	{{ order.orderDate }}</p>
						<p>	{{ order.phoneNumber }}</p>
						<p>	{{ order.deliveryAddress }}</p>
						</td>
          </tr>
          <tr v-if="selectedOrderIndex === index" class="order-details">
            <td colspan="4">Товар</td>
            <td colspan="3">Цена за единицу</td>
            <td colspan="1">Сумма</td>
          </tr>
          <template v-if="selectedOrderIndex === index">
            <tr v-for="product in order.products" :key="product.id" class="order-details">
              <td colspan="2"><img :src="product.url" alt="" height="87" style="max-width: 87px;"></td>
              <td colspan="2">
							<h4>{{ product.name }}</h4>	
							<p>	{{ product.brand }}</p>
							</td>
              
              <td colspan="2">{{ product.quantity }} x {{ product.price }}</td>
              <td colspan="2">{{ calculateFinalPrice(product.quantity, product.price) }}</td>
            </tr>
          </template>
        </template>
      </tbody>
    </table>
  </div>
</template>


<script>
export default {
	data() {
		return {
			orders: [
				{
					id: 1,
					numberOrder: '195455-222546-ANU',
					price: 1800,
					statusOrder: 'Возврат',
					address: 'Lukacheva 34a',
					deliveryMethod: 'Курьером',
					orderDate: '12 марта , 21:25',
					phoneNumber: '+7 095 655 88 44',
					deliveryAddress: "Иванов Иван Иванович\nПокровский проезд, 5, Москва, 054555",
					products: [
						{
							url: "/imgs/logoItem1.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 1,
							price: 53000,
						}, {
							url: "/imgs/logoItem2.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 2,
							price: 22000,
						}
					]
				}, {
					id: 2,
					numberOrder: '195455-222546-ANU',
					price: 2200,
					statusOrder: 'Принято в обработку',
					address: 'Samoilovo 12',
					deliveryMethod: 'Курьером',
					orderDate: '12 марта , 21:25',
					phoneNumber: '+7 095 655 88 44',
					deliveryAddress: "Иванов Иван Иванович\nПокровский проезд, 5, Москва, 054555",
					products: [
						{
							url: "/imgs/logoItem1.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 1,
							price: 53000,
						}, {
							url: "/imgs/logoItem2.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 2,
							price: 22000,
						}
					]
				}, {
					id: 3,
					numberOrder: '195455-222546-ANU',
					price: 98000,
					statusOrder: 'Доставлено',
					address: 'Madridskay 56',
					deliveryMethod: 'Курьером',
					orderDate: '12 марта , 21:25',
					phoneNumber: '+7 095 655 88 44',
					deliveryAddress: "Иванов Иван Иванович\nПокровский проезд, 5, Москва, 054555",
					products: [
						{
							url: "/imgs/logoItem1.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 1,
							price: 53000,
						}, {
							url: "/imgs/logoItem2.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 2,
							price: 22000,
						}
					]
				}, {
					id: 4,
					numberOrder: '195455-222546-ANU',
					price: 100,
					statusOrder: 'Завершен',
					address: 'Bomjei st 1',
					deliveryMethod: 'Курьером',
					orderDate: '12 марта , 21:25',
					phoneNumber: '+7 095 655 88 44',
					deliveryAddress: "Иванов Иван Иванович\nПокровский проезд, 5, Москва, 054555",
					products: [
						{
							url: "/imgs/logoItem1.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 1,
							price: 53000,
						}, {
							url: "/imgs/logoItem2.png",
							name: "Popuas",
							brand: "Gibson",
							quantity: 2,
							price: 22000,
						}
					]
				},
			],
			selectedOrderIndex: -1, // индекс выбранного заказа для отображения деталей
		};
	},
	methods: {
		toggleDetails(index) {
			// Переключаем отображение деталей для конкретного заказа
			this.selectedOrderIndex = this.selectedOrderIndex === index ? -1 : index;
		},
		fetchOrders() {
			// API запрос для получения данных заказов
			// Это псевдокод, замените на реальный запрос к вашему API
			this.axios.get('/api/orders')
				.then(response => {
					this.orders = response.data;
				})
				.catch(error => {
					console.error("Ошибка при загрузке заказов:", error);
				});
		},
		calculateFinalPrice(quantity, price) {
			return price * quantity;

		}
	},
	mounted() {
		// this.fetchOrders();
	}
};
</script>

<style scoped src="@/assets/css/accountOrdersComponent.css">
</style>
