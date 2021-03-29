
<template>
  <div>
    <div class="aside">
      <div class="open-close-trigger" @click="editPageView = !editPageView">Aç Kapa</div>
      <div v-if="editPageView && selectedItem == null && readyForAddElement == null">
        <section>
          <label>Grid System</label>
          <div @click="addElement([{ 'el': 'div', 'class' : 'row','subElement' : [] }])">Satır</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-12','subElement' : [] }])">12</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-6', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-6', 'subElement' : [] }])">6 : 6</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-8', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] }])">8 : 4</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-8', 'subElement' : [] }])">4 : 8</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-2', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-10','subElement' : [] }])">2 : 10</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-10','subElement' : [] },{'el': 'div', 'class' : 'col-sm-2', 'subElement' : [] }])">10 : 2</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-4', 'subElement' : [] }])">4 : 4 : 4</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-3', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-3', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-3', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-3', 'subElement' : [] }])">3 : 3 : 3 : 3</div>
        </section>
        <section>
          <label>Html</label>
          <div @click="addElement([{ 'el': 'label', 'text'  : 'Label' }])"> Label </div>
          <div @click="addElement([{ 'el': 'p',     'text'  : 'paragraf' }])"> Paragraf </div>
          <div @click="addElement([{ 'el': 'img',   'src'   : 'https://via.placeholder.com/150' }])"> Img </div>
        </section>
        <section>
          <label>Components</label>
          <div @click="addElement([{ 'el': 'legend','html'  : 'Custom' }])"> Summernote </div>
          <div @click="addElement([{ 'el': 'bulten'}])"> Bulten </div>
          <div @click="addElement([{ 'el': 'breadCrumb', 'urlList' : [{'url' : '/' , 'name' : 'Anasayfa'}]}])"> Bread Crumb </div>
          <div @click="addElement(models.Carousel)"> Slider </div>
          <div @click="addElement([{ 'el': 'recentpost','blogList' : [{'title':'title','date' : '24.01.2021','content' : { 'html_desktop' : 'Lorem ipsum dolar sit amet'}},{'title':'title','date' : '24.01.2021','content' : { 'html_desktop' : 'Lorem ipsum dolar sit amet'}},{'title':'title','date' : '24.01.2021','content' : { 'html_desktop' : 'Lorem ipsum dolar sit amet'}}] }])"> Recent Post </div>
          <div @click="addElement([{ 'el': 'blogList', 'pageUrl':'pageUrl', 'blogList' : [{'banner':{'url':'https://via.placeholder.com/150','title':'https://via.placeholder.com/150'},'url':'/','title':'title','date' : '24.01.2021','content' : { 'html_mini' : 'Lorem ipsum dolar sit amet'}},{'banner':{'url':'https://via.placeholder.com/150','title':'https://via.placeholder.com/150'},'url':'/','title':'title','date' : '24.01.2021','content' : { 'html_mini' : 'Lorem ipsum dolar sit amet'}}] }])"> Blog List </div>
        </section>
        <section>
<!--          <div class="deleteEnable" @click="deleteModeTrigger"> Delete  </div>-->
<!--          <div class="updateEnable" @click="update"> Update  </div>-->
        </section>
      </div>
    </div>

    <div class="page-main-view">
      <div :class="[readyForAddElement != null ? 'preview-active' : 'preview']">
        <header-component></header-component>
        <div style="background: white;position: relative;float: left;min-height: 300px;width: 100%">
          <html-object :elements="elements"
                       @slider-change="elementChange"
                       @src-change="elementChange"
                       @css-change="elementChange"
                       @text-change="elementChange"
                       @bread-crumb-change="elementChange"

                       @remove-item="removeItem"
                       @click-item="clickedItem"></html-object>
        </div>
        <footer-component></footer-component>
      </div>
    </div>

    <div id="div-edit-css-popup" class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
          </div>
          <div class="modal-body">
<!--            <input v-model="css">-->
          </div>
          <div class="modal-footer">
<!--            <button type="button" class="btn btn-primary" @click="saveCSS">Save changes</button>-->
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>

    <input-edit-component       @click-item="inputEditChange"></input-edit-component>

    <img-edit-component         @click-item="imgEditChange"></img-edit-component>

    <carousel-edit-component    @click-item="carouselEditChange"   v-if="selectedItem != null && selectedItem.imageList != null" :selected-images="selectedItem.imageList"></carousel-edit-component>

    <bread-crumb-edit-component @click-item="breadCrumbEditChange" v-if="selectedItem != null && selectedItem.imageList == null" :url-list="selectedItem"></bread-crumb-edit-component>

    <legend-edit-component      @click-item="legendChange"></legend-edit-component>

  </div>
</template>

<script>
import AddImage from "./tools/addImage";
import HeaderComponent from "./ui/headerComponent";
import BultenComponent from "./general/bultenComponent";
import HtmlObject from "./general/htmlObject";
import FooterComponent from "./ui/footerComponent";
import Models from "../JsonInitModels/Models";
import InputEditComponent from "./edit/inputEditComponent";
import ImgEditComponent from "./edit/imgEditComponent";
import CarouselEditComponent from "./edit/carouselEditComponent";
import LegendEditComponent from "./edit/legendEditComponent";
import BreadCrumbEditComponent from "./edit/breadcrumbEditComponent";
console.log("5");
export default {
  name: "pagesComponent",
  components: {
    BreadCrumbEditComponent,
    LegendEditComponent,
    CarouselEditComponent,
    ImgEditComponent,
    InputEditComponent,
    AddImage,
    FooterComponent,
    HeaderComponent,
    BultenComponent,
    HtmlObject
  },
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
      models :Models,

      selectedItem : null,
      editPageView : false,
    }
  },
  methods:{
    //Select & Add element
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

    // deleteModeTrigger(){
    //   if(!this.$store.state.readyToDelete){
    //     setTimeout(function (){
    //       //FOR CSS
    //       setTimeout(function (){
    //         $($(".preview span")[0]).hide();
    //         $($(".preview span")[1]).hide();
    //         $($(".preview span")[2]).hide();
    //       },100)
    //     },100)
    //   }
    //   this.$store.state.readyToDelete = !this.$store.state.readyToDelete;
    // },
    removeItem(item){
      item = null;
    },

    elementChange(item){
      if(item.el == 'legend'){
        $("#legend-edit-popup").modal('show')
      }else if(item.el == 'p' || item.el == 'label'){
        $("#input-edit-popup").modal('show')
      }else if(item.el == 'img'){
        $("#input-img-popup").modal('show')
      }else if(item.length>0){
      // }else if(item.el == 'breadCrumb'){
        $("#input-bread-crumb-popup").modal('show')
      // }else if(item.imageList != 'slider'){
      }else if(item.imageList != null){
        $("#input-carousel-popup").modal('show');
      }else if(item.el == 'div'){
        $("#div-edit-css-popup").modal('show')
      }
      this.selectedItem = item;
    },

    //EDIT
    inputEditChange(text,css){
      this.selectedItem.text = text;
      this.selectedItem.css = css;
      $("#input-edit-popup").modal('show')
      this.selectedItem = null;
    },
    imgEditChange(url,css){
      this.selectedItem.src = url;
      this.selectedItem.css = css;
      $("#input-img-popup").modal('hide')
      this.selectedItem = null;
    },
    legendChange(code){
      this.selectedItem.html = code;
      $("#legend-edit-popup").modal('hide')
      this.selectedItem = null;
    },
    carouselEditChange(images,html){
      this.selectedItem.imageList = images;
      this.selectedItem.html = html;
      $("#input-carousel-popup").modal('hide');
      this.selectedItem = null;
    },
    breadCrumbEditChange(urlList){
      this.selectedItem = urlList;
      $("#input-bread-crumb-popup").modal('hide')
      this.selectedItem = null;
    },
    
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
  .aside{
    position: absolute;
    border: 1px solid black;
    z-index: 9999;
    background: #f4f4f4;

  }
  .aside .deleteEnable{
    width: 46%;
    float: left;
    margin-left:  2%;
    margin-right: 2%;
    margin-top: 5px;
    border: 4px solid red;
    text-align: center;
  }
  .aside .updateEnable{
    width: 46%;
    float: left;
    margin-left:  2%;
    margin-right: 2%;
    margin-top: 5px;
    border: 4px solid red;
    text-align: center;
  }
  .aside div{
    width: 100%;
    margin: 2px;
  }
  .aside div::before {
    content: "-   ";
  }
  .aside label{
    width: 100%;
    border-bottom: 1px solid red;
  }
  .aside section{
    width: 45%;
    margin-left: 2.5%;
    margin-right: 2.5%;
    float: left;
    position: relative;
  }
  .preview{
    border: 1px solid black;
    width: 100%;
    float: left;
    position: relative;
    min-height: 75%;
  }
  .preview-active{
    border: 2px solid black;
    width: 100%;
    float: left;
    position: relative;
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

  .preview .active-show-border{
    height: auto;
    float: left;
    position: relative;
    width: 100%;
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
