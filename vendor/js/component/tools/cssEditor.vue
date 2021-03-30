<template>
  <div>
    <span> { </span>
      <textarea v-model="enteredValue"></textarea>
    <span> } </span>
  </div>
</template>

<script>
export default {
  name: "cssEditor",
  props:['css'],
  model: {
    prop: 'css',
    event: 'change'
  },
  data: function () {
    return {
      enteredValue: null,
    }
  },
  mounted: function () {
    this.enteredValue = this.value;
  },
  watch: {
    enteredValue: function (val) {
      this.$emit('change', val);
    },
  },
}
</script>

<style scoped>

</style>