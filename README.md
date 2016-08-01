## 新发现一个控件FragmentTabHost可以替换RadioButton，原因如下：
* 1.TabSpec设置tab的样式，可以通过xml自定义，不受RadioButton的限制(如无法使图片居中):
	> TabHost.TabSpec tabSpec = mTabHost.newTabSpec(String.valueOf(i+1)).setIndicator(getTabItemView(i));
	> 
	> getTabItemView(i)-->Tab_imag.setImageResouce(Selector);
* 2.mTabHost.addTab(tabSpec, fragmentArray[i],null);通过这种方式设置的fragment默认为摧毁视图模式
* 第一个fragment自动加载,Tab自动Selected，其他fragment懒加载。
* 3.mTabHost提供TabChange监听,自由设置加载模式(如视图隐藏模式)
* main.xml:
* 
		<FrameLayout
			android:id="@+id/real_tab_content"
        	android:layout_width="match_parent"
        	android:layout_height="0dp"
        	android:layout_weight="1"/>

			<android.support.v4.app.FragmentTabHost
        	android:id="@+id/tab_host"
        	android:layout_width="match_parent"
        	android:layout_height="wrap_content"
        	android:background="@color/colorPrimary">

        <FrameLayout
            android:id="@+id/tab_content"
            android:layout_width="0dp"
            android:layout_height="0dp" />
    	</android.support.v4.app.FragmentTabHost>
* item.xml(完全自定义啊有木有！gravity：center)
* 
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    		android:layout_width="match_parent"
    		android:layout_height="match_parent"
    		android:gravity="center">

    	<ImageView
			android:id="@+id/tab_img"
        	android:layout_width="wrap_content"
        	android:layout_height="wrap_content" />
		</RelativeLayout>
* selector:
* 
		<selector xmlns:android="http://schemas.android.com/apk/res/android">
    		<item android:drawable="@drawable/tab_guanyu_press" android:state_selected="true"/>
    		<item android:drawable="@drawable/tab_guanyu_normal"/>
		</selector>
## 关于Selector:
* 1.selected ：选中(持续)
* 2.press:按下(只有一瞬间)
* 3.目前还不懂focused是啥意思。。。以后再看看
* 4.最后一个item不设置状态为默认状态
