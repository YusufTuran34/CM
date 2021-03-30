<template>
  <div id="input-carousel-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-6" style="max-height: 500px;overflow: auto">
              <div v-for="(image,index) in selectedImagesObj">
                <img style="height: 100px;width: 200px;padding: 10px;border: 1px solid;" :src="image" alt="resim">
                <button class="btn btn-outline-danger" @click="deleteFile(index)">x</button>
                <add-image :btn-name="'Güncelle'" @file-change="selectedImagesChange($event,index)"></add-image>
              </div>
              <br>
              <add-image :btn-name="'Yeni Ekle'" @file-change="fileAdd"></add-image>
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
  props:['selectedImages','html'],
  components: {AddImage},
  methods:{
    deleteFile(index){
      this.selectedImages.splice(index,1);
    },
    fileAdd(file){
      this.selectedImages.push(file);
    },
    selectedImagesChange(file,index){
      this.$set(this.selectedImages,index,file)
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
    $("#summernoteCarousel").summernote({
      height: 400
    });
    $("#summernoteCarousel").summernote('code',this.html);
  }
}
</script>

<style scoped>

</style>