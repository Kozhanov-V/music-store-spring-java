<template>
  <div class="slider-container" :style="{ width: computedWidth, height: computedHeight }">
    <div class="slides" :style="slideStyle">
      <img v-for="(image, index) in images" :key="index" :src="image.src" :alt="`Slide ${index + 1}`" :style="{ width: computedWidth, height: computedHeight }">
    </div>
		<button @click="nextSlide">Next</button>
    <button @click="prevSlide">Previous</button>

  </div>
</template>

<script>
export default {
  props: {
    images: Array,
    width: String,
    height: String
  },
  data() {
    return {
      currentSlide: 0
    };
  },
  computed: {
    computedWidth() {
      return this.width || '100%';
    },
    computedHeight() {
      return this.height || 'auto';
    },
    slideStyle() {
      // Расчет сдвига для transform
      const offset = -(this.currentSlide * 100);
      return {
        transform: `translateX(${offset}%)`
      };
    }
  },
  methods: {
    nextSlide() {
      this.currentSlide = (this.currentSlide + 1) % this.images.length;
    },
    prevSlide() {
      this.currentSlide = (this.currentSlide + this.images.length - 1) % this.images.length;
    }
  }
};
</script>


<style scoped>
.slider-container {
  position: relative;
  overflow: hidden;
	display: block;
    margin-left: auto;
    margin-right: auto
}

.slides {
  display: flex;
  transition: transform 0.3s ease-in-out;
  transform: translateX(0%); /* Изначальное положение */
}


.slides img {
  max-width: 100%;
  display: block;
}

button {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
}

button:nth-child(2) {
  right: 10px;
}

button:nth-child(3) {
  left: 10px;
}
</style>
