<template>
  <div>
    <input ref="file" type="file" style="display: none;" @change="onChange($event)" class="form-control">
    <button  class="btn btn-outline-secondary " type="button" @click="$refs.file.click()">Resim Seç</button>
  </div>
</template>

<script>
console.log("hebeleCom");
export default {
  name: "addImage",
  data: function () {
    return {
      selectedImage: null
    }
  },
  methods: {
    onChange(e) {
      const file = e.target.files[0];
      this.$emit('file-change',URL.createObjectURL(file));
    },
  }
}
</script>

<style scoped>

button{
  display: block;
  padding: inherit;
  border: dashed;
  z-index: 1;
}

img{
  height: 50px;
  width: 50px;
}

</style>
