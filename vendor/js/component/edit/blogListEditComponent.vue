<template>
  <div id="blog-list-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div class="row">

          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "blogListEditComponent",
  model: {
    prop: 'selectedItem',
    event: 'change'
  },
  props:['selectedItem'],
  methods:{

  },
  computed: {

  },
  mounted() {
    $("#summernoteBlog").summernote({
      height: 400
    });
  }
}
</script>

<style scoped>

</style>