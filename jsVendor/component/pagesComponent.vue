<template>
  <div>
    <div class="aside">
      <label>Grid System</label>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-12','subElement' : [] }])">12</div>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-6', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-6', 'subElement' : [] }])">6 : 6</div>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-8', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] }])">8 : 4</div>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-4', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-4', 'subElement' : [] }])">4 : 4 : 4</div>
      <div @click="addElement([{ 'el': 'label', 'text'  : 'Label' }])"> Label </div>
      <div @click="addElement([{ 'el': 'p',     'text'  : 'paragraf' }])"> Paragraf </div>
      <div @click="addElement([{ 'el': 'legend','html'  : 'Custom' }])"> Summernote </div>
      <div @click="deleteModeTrigger"> Delete  </div>

    </div>

    <div :class="[readyForAddElement != null ? 'preview-active' : 'preview']">
      <html-object :elements="elements" @remove-item="removeItem" @click-item="clickedItem" @text-change="textChange"></html-object>
    </div>
    <div v-show="selectedItem != null && selectedItem.el != 'legend'">
      <div id="input-edit-popup" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
            </div>
            <div class="modal-body">
              <input v-model="text">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" @click="saveText">Save changes</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-show="selectedItem != null && selectedItem.el == 'legend'">
      <div id="legend-edit-popup" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
            </div>
            <div class="modal-body">
              <div id="summernote"></div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" @click="saveSummernote">Save changes</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
console.log("19");
import HtmlObject from "./pageGame/htmlObject";
export default {
  name: "pagesComponent",
  components: {HtmlObject},
  data:function (){
    return {
      elements : [
        {
          "el"          : "div",
          "class"       : "container",
          "css"         : "",
          "subElement"  : [
            {
              "el"      : "div",
              "class"   : "row",
              "subElement" : [
                {
                  "el"          : "div",
                  "class"       : "col-sm-12",
                  "css"         : "",
                  "subElement"  : []
                }
              ]
            },
          ]
        }
      ],
      text : null,
      selectedItem : null,
    }
  },
  methods:{
    deleteModeTrigger(){
      if(!this.$store.state.readyToDelete){
        setTimeout(function (){
          //FOR CSS
          setTimeout(function (){
            $($(".preview span")[0]).hide();
            $($(".preview span")[1]).hide();
            $($(".preview span")[2]).hide();
          },100)
        },100)
      }
      this.$store.state.readyToDelete = !this.$store.state.readyToDelete;
    },
    addElement(el){
      this.$store.dispatch("setReadyCreateElement",el)
      //FOR CSS
      setTimeout(function (){
        $($(".preview-active span")[0]).hide();
        $($(".preview-active span")[1]).hide();
        $($(".preview-active span")[2]).hide();

        $($(".preview-active span")[$(".preview-active span").length-1]).hide();
        $($(".preview-active span")[$(".preview-active span").length-2]).hide();
        $($(".preview-active span")[$(".preview-active span").length-3]).hide();
      },100);
    },
    clickedItem(item){
      let elements = item.element
      if(item.order == 'first'){
        for(var i=this.$store.state.element.length-1;i>=0;i--){
          elements.unshift(this.$store.state.element[i]);
        }
      }else if(item.order == 'last'){
        for(var i=0;i<this.$store.state.element.length;i++){
          elements.push(this.$store.state.element[i]);
        }
      }else{
        console.log("unexpected order for elements");
      }
      item.element = elements;
      this.$store.state.element = null;

    },
    removeItem(item){
      item = null;
    },
    textChange(item){
      if(item.el == 'legend'){
        $("#legend-edit-popup").modal('show')
      }else{
        $("#input-edit-popup").modal('show')
      }
      this.selectedItem = item;
    },

    saveText(){
      this.selectedItem.text = this.text;
      this.selectedItem = null;
      this.text = null;
    },
    saveSummernote(){
      this.selectedItem.html = $("#summernote").summernote('code');
      $("#summernote").summernote('code',null);
      $(".modal").modal('close');
      this.selectedItem = null;
      this.text = null;
    }
  },
  computed: {
    readyForAddElement(){
      return this.$store.state.element
    },
  },
  mounted() {
    $("#summernote").summernote({
      tabsize: 2,
      height: 400
    });
  }
}
</script>

<style>
  .preview{
    border: 1px solid black;
    width: 100%;
    min-height: 75%;
  }
  .preview-active{
    border: 2px solid black;
    width: 100%;
    min-height: 75%;
  }
  .preview-active .container{
    border: 1px solid #212529;
    min-height: 50px;
    position: relative !important;
    float: left !important;
    width: 90%  !important;
    margin: 5%  !important;
    margin: 5%  !important;
  }
  .preview-active .row{
    border: 1px solid #212529;
    min-height: 50px;
    position: relative !important;
    float: left !important;
    width: 90%  !important;
    margin: 5%  !important;
    margin: 5%  !important;
  }


  .preview-active .active-show-border{
    border: 2px solid red !important;
    height: auto;
    float: left;
    position: relative;
    width: 100%;
  }
  .preview-active .active-show-border span{
    width: 100%;
    border: 1px solid black;
    float: left;
    position: relative;
  }



</style>