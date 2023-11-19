<template>
  <swiper :slides-per-view="1" 
	:space-between="50" 
	:slidesPerView="this.countItem" 
	:centeredSlides="true" >
    <swiper-slide v-for="(image, index) in images" :key="index">
     <a :href="image.url"><img :src="image.src" :alt="`Slide ${index}`" :style="{ width: this.width, height: this.height }"></a> 
    </swiper-slide>
  </swiper>
</template>

<script>
// Импортируем Swiper и стили Swiper
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css';

export default {
  components: {
    Swiper,
    SwiperSlide
  },
  props: {
    images: {
      type: Array,
      required: true
    },
		width: String,
    height: String,
		countItem: Number
  }
};
</script>

<style scoped>
.swiper {
  width: 100%;
  height: 100%;
}

.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
}

.swiper-button-prev,
.swiper-button-next {
	color: black;
}
</style>
