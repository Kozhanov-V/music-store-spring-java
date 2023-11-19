<template>
	<footer class="footer">
		<div class="footer-container">


			<div class="footer-top">
				<div class="footer-apps">
					<a href="#" class="app-link">
						<img src="/imgs/logoFooter.svg" alt="Logo company">
					</a>
				</div>
			</div>
			<div class="footer-middle">
				<div class="footer-social-media">
					<h3>Наши социальные сети</h3>
					<a href=""><img src="/imgs/logoVk.svg" alt="" height="50" width="50"></a>
					<a href=""><img src="/imgs/logoInstagram.svg" alt="" height="50" width="50"></a><br>
					<a href=""><img src="/imgs/telegram.svg" alt="" height="50" width="50"></a>
				</div>
				<div class="footer-contact">
					<h4>Контакты</h4>
					<div class="contacts-element first-contact-element" >
								<img src="/imgs/logoPhone.png" alt="" width="23" height="23">
						<div class="contact-info">
							<h3>8 (800) 511-74-68</h3>
							<p>Бесплатная горячая линия
								Ежедневно с 9 до 21</p>
						</div>

					</div>
					<div class="contacts-element">
						<img src="/imgs/mailLogo.png" alt="" width="25" height="20">
						<div class="contact-info">
							<h3>Контактный Email</h3>
							<p>info@brd.ru</p>
						</div>
					</div>
				</div>
				<div class="footer-links">
					<div class="links-column">
						<h3>Помощь</h3>
						<a href="">Доставка</a>
						<a href="">Оплата</a>
						<a href="">Возврат</a>
						<a href="">Акции и скидки</a>
					</div>
					<div class="links-column">
						<h3>Компания</h3>
						<a href="">Контакты</a>
						<a href="">О "Название компании"</a>
						<a href="">Публичная оферта</a>
					</div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="social-media">
					<!-- Insert your social media links here -->
				</div>
			</div>
		</div>
	</footer>
</template>

<style>
.footer {
	color: #F2F2F2;
	background-color: black;
	font-family: 'Your font', sans-serif;
	padding: 20px;
	font-size: 14px;
	margin-top: 100px;
}

.footer-container {
	width: 1360px;
	margin-left: auto;
	margin-right: auto;
}

.footer-top {
	margin-bottom: 20px;
}

.footer-top,
.footer-middle,
.footer-bottom {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.footer-apps {
	/* Adjust as per your layout */
}

.app-link img {
	/* Set appropriate sizes */
}

.qr-code img {
	/* Set appropriate sizes */
}

.footer-signup h4 {
	margin-bottom: 10px;
}

.signup-btn {
	/* Style your button */
}

.footer-middle {
	border-top: 1px solid #333;
	/* Adjust color to match design */
	border-bottom: 1px solid #333;

	padding-top: 40px;
	padding-bottom: 40px;
}

.footer-social-media *{
	margin: 5px;
}

.footer-contact p {
	margin-top: 10px;
}

.footer-contact h3 {}

.footer-contact h4 {
}
.first-contact-element{
	margin-top: 32px;
}
.contacts-element{
	display: flex;
}
.contact-info{
	margin-left: 25px;
}
.contacts-element{
	margin-bottom: 20px;
}

.footer-links {
	display: flex;

}

.footer-links a {
	color: #BDBDBD;
	margin-top: 20px;
}

.footer-links .links-column {
	margin-right: 40px;
	/* Adjust spacing */
}

.links-column {
	display: flex;
	flex-direction: column;
}

.links-column {
	margin-bottom: 5px;
}

.footer-bottom {
	padding-top: 20px;
}

.social-media {
	/* Add styles for your social media icons */
}

.social-media a {
	margin-right: 10px;
}

.copyright {
	text-align: right;
}
</style>