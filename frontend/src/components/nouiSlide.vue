<template>

  <div class="price-slider">
    <div class="slider" ref="slider"></div>
    <div class="slider-inputs">
      <input type="text" id="input-min" ref="inputMin" readonly>
      <span>—</span>
      <input type="text" id="input-max" ref="inputMax" readonly>
    </div>
  </div>
</template>

<script>
import noUiSlider from 'nouislider';
import 'nouislider/dist/nouislider.min.css';

export default {
  data() {
    return {
      minPrice: 5000,
      maxPrice: 126456
    };
  },
  mounted() {
    noUiSlider.create(this.$refs.slider, {
      start: [this.minPrice, this.maxPrice],
      connect: true,
      range: {
        'min': this.minPrice,
        'max': this.maxPrice
      },
      tooltips: true,
      format: {
        to: function (value) {
          return parseInt(value).toLocaleString();
        },
        from: function (value) {
          return Number(value.replace(',', ''));
        }
      }
    });

    this.$refs.slider.noUiSlider.on('update', (values) => {
      this.$refs.inputMin.value = values[0];
      this.$refs.inputMax.value = values[1];
    });
  }
};
</script>

<style>
.price-slider {
	margin-top: 35px;
}

.slider {
  margin-top: 1rem;
  margin-bottom: 1rem;
}

.slider-inputs {
  display: flex;
  justify-content: space-between;
}

.slider-inputs input {
    border: none;
    padding: 0.5rem;
    width: 110px;
    text-align: center;
    font-size: 15px;
    font-weight: 100;
    background-color: #f9f9f9;
}

/* Стилизация noUiSlider */
.noUi-handle {
  border: 2px solid #EB5757;
  box-shadow: none;
  outline: none;
  background-color: white;
  cursor: pointer;
  border-radius: 50%;
}

.noUi-connect {
  background: #EB5757;
}

.noUi-tooltip {
  display: none;
}
.noUi-horizontal{
	height: 5px;
}
.noUi-horizontal .noUi-handle {
    width: 23px;
    height: 23px;
    right: -17px;
    top: -10px;
}
.noUi-handle {
    border: 4px solid #EB5757;
    box-shadow: none;
    outline: none;
    background-color: white;
    cursor: pointer;
    border-radius: 50%;
}
.noUi-handle:after, .noUi-handle:before {
    content: "";
    display: block;
    position: absolute;
    height: 14px;
    width: 1px;
     background: none; 
    left: 14px;
    top: 6px;
}
.slider-inputs span{
	color: #bdbdbd;
	margin-top: 5px;
}

</style>
