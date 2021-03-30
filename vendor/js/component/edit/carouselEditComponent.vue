<template>
  <div id="input-carousel-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-6">
              <div v-for="(image,index) in selectedImagesObj">
                <img style="height: 100px;width: 100px" :src="image" alt="resim">
                <button @click="deleteFile(index)">Sil</button>
                <add-image :btn-name="'Güncelle'" @file-change="selectedImagesChange($event,index)"></add-image>
              </div>
              <label>Yeni Ekleme</label>
              <add-image :btn-name="'Ekle'" @file-change="fileAdd"></add-image>
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
    $("#summernoteCarousel").summernote();
  }
}
</script>

<style scoped>

</style>