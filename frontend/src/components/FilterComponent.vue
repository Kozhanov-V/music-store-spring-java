<template>
	<h4>{{ this.name }}</h4>
	<ul class="categories__list">
		<li v-for="category in attributesList" :key="category.name">
			<label class="custom-checkbox">
				<input type="checkbox" :value="category.name" v-model="selectedCategories" :id="category.name"
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

		}
	},
	props: {
		name: String,
    attributesList: Array
  }
}
</script>
<style>


</style>