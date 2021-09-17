import vue from 'vue'
import { Button } from 'element-ui'
import { Form,FormItem } from 'element-ui'
import{Input} from 'element-ui'
import{Message} from 'element-ui'
import{Container,Header,Aside,Main} from 'element-ui'
import {Menu, Submenu, MenuItemGroup, MenuItem, Breadcrumb,
    BreadcrumbItem, Card, Row, Col, Table, TableColumn, Switch, Tooltip, Pagination,
    Dialog, MessageBox, Tag, Tree, Select, Option, Cascader, Alert, Tabs, TabPane,
    Step, Steps, Checkbox, CheckboxGroup, Upload,
    Timeline, TimelineItem } from 'element-ui'
import { use } from 'vue/types/umd'

vue.use(Button)
vue.use(Form)
vue.use(FormItem)
vue.use(Input)
vue.use(Container)
vue.use(Aside)
vue.use(Header)
vue.use(Main)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItemGroup)
Vue.use(MenuItem)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Card)
Vue.use(Row)
Vue.use(Col)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Switch)
Vue.use(Tooltip)
Vue.use(Pagination)
Vue.use(Dialog)
Vue.prototype.$confirm = MessageBox.confirm
Vue.use(Tag)
Vue.use(Tree)
Vue.use(Select)
Vue.use(Option)
Vue.use(Cascader)
Vue.use(Alert)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Step)
Vue.use(Steps)
Vue.use(Checkbox)
Vue.use(CheckboxGroup)
Vue.use(Upload)
Vue.use(Timeline)
Vue.use(TimelineItem)
vue.prototype.$message=Message