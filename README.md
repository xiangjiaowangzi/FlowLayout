# FlowLayout

本项目用作练习FlexboxLayout，并在此基础上进行修改；

FlexboxLayout介绍：

## 父属性介绍 ##


### flexWrap ###
属性表示换行与否，默认为noWrap

wrap ：自动换行

wrap_reverse ：副轴反转


### flexDirection       ###
表示子元素的排列方向，元素的排列方向为主轴的方向

图：

![](https://i.imgur.com/c1DOqZx.png)

row：默认属性

### justifyContent  ###

表示控件沿主轴对齐方向

flex_start ：左对齐 默认

flex_end：右对齐

space_around：子元素两端的距离相等，所有子元素两端的距离都相相等

space_between：两端对齐，子元素之间的间隔相等，但是两端的子元素分别和左右两边的间距为0

center 内容往中间对齐

### alignContent  ###

表示控件在副轴上的对齐方向（针对多行元素）

stretch：默认值，表示占满整个副轴

其余属性justifyContent属性相对应

### alignItems  ###

表示单行的元素对齐方式，属性含义和上文基本一致，只是多了一个baseline，表示基线对齐；

## 子元素属性 ##

###  layout_order ###

这个表示子元素的优先级，默认值为1，数值越大越靠后显示。

### layout_flexGrow ###

类似权重属性；

### layout_flexShrink ###

表示空间不足时子控件的缩放比例，0表示不缩放



