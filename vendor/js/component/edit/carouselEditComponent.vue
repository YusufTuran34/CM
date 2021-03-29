<template>
  <div id="input-carousel-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-6">
              <div v-for="image in selectedImagesObj">
                <img :src="image" alt="resim">
              </div>
              <add-image @file-change="selectedImagesChange"></add-image>
            </div>
            <div class="col-sm-6">
              <div id="summernoteCarousel"></div>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" @click="saveCarousel">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AddImage from "../tools/addImage";
export default {
  name: "carouselEditComponent",
  props:['selectedImages'],
  components: {AddImage},
  methods:{
    selectedImagesChange(file){
      this.selectedImagesObj.push(file);
    },
    saveCarousel(){
      this.$emit('click-item',this.selectedImagesObj,$("#summernoteCarousel").summernote('code'))
    }
  },
  computed: {
    selectedImagesObj() {
      return JSON.parse(JSON.stringify(this.selectedImages));
    },
  },
  mounted() {
    $("#summernoteCarousel").summernote();
  }
}
</script>

<style scoped>

</style>