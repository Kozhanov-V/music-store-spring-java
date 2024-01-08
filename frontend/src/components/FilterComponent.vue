<template>
	<h4>{{ this.name }}</h4>
	<ul class="categories__list">
		<li v-for="category in attributesList" :key="category.id">
			<label class="custom-checkbox">
				<input type="checkbox" :value="category.value" v-model="selectedCategories" :id="category.id"
					class="custom-checkbox-input">
				<span class="custom-checkbox-box"></span>
				<span class="custom-checkbox-name">{{ category.value }}</span>
				<span class="custom-checkbox-count"> {{ category.count }}</span>
			</label>
		</li>
	</ul>
</template>
<script>
export default {
	data() {
		return {
			selectedCategories: []
		}
	},
	props: {
		name: String,
    attributesList: Array
  },
  watch: {
    selectedCategories(newVal) {
      this.$emit('update-attributes', { [this.name]: newVal });
    }
  }
}
</script>
<style scoped src="@/assets/css/catalogPage.css">


</style>