<template>
	<div class="app">
		<AppHeader/>
	</div>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue"

export default {
	
	components:{
		AppHeader
	}
}
</script>

<style>

@font-face {
font-family: GrtskPeta;
src: url(@/assets/fonts/GrtskPeta-Regular.ttf);
font-weight:900;
}
@font-face {
font-family: GrtskPeta-Bold;
src: url(@/assets/fonts/GrtskPeta-Bold.ttf);
font-weight:900;
}
@font-face {
font-family: GrtskPeta-Medium;
src: url(@/assets/fonts/GrtskPeta-Medium.ttf);
font-weight:900;
}
.app{
	display: flex;
align-items: center;
justify-content: center;
}
h1{
	font-size: 48px;
	font-family: GrtskPeta-Bold;
}
h2{
	font-size: 32px;
	font-family: GrtskPeta-Bold;
}
h3{
	font-size: 21px;
	font-family: GrtskPeta-Bold;
}
h4{
	font-size: 16px;
	font-family: GrtskPeta-Medium;
}
a{
	color: black;
  text-decoration: none;
}
.caption{
	font-family: GrtskPeta-Medium;
	font-size: 8px;
}

*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: GrtskPeta;
}
</style>
