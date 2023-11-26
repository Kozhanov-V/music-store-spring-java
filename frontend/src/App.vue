<template>
	<div id="app">
		<AppHeader/>
		<router-view></router-view>
		<AppFooter/>
		<vue-slider
    v-model="value"
    :min="options.min"
    :max="options.max"
    :tooltip="'always'"
    :tooltip-style="{ backgroundColor: '#E8E8E8', borderColor: '#E8E8E8' }"
    :process-style="{ backgroundColor: '#FF5252' }"
    :dot-style="{ borderColor: '#FF5252' }"
  ></vue-slider>
	</div>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue"
import AppFooter from "@/components/AppFooter.vue"

export default {
	
	components:{
		AppHeader,AppFooter
	},

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
p{
	color: #828282;
	font-size: 14px;
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
