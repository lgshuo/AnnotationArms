# AnnotationArms
一款基于注解开发的轻量级mvp架构

1.封装RxPermission2动态权限

2.使用dagger2 将presenter层注入到ui层

3.基于Rxjava2+retrofit2访问网络

4.使用注解绑定ui层的布局

5.使用注解对网络请求结果进行处理

部分代码

	1.使用注解绑定布局

	@ContentView(R.layout.activity_search)
	public class SearchActivity extends BaseHttpActivity<SearchPresenter>{
	}
		
	2.使用注解对网络结果进行处理	

 	@onSuccess(url = Url.novalType)
    public void requestNovalTypeSuccess(String response){
    }

	3.动态权限请求

      PermissionHelper.requestForWriteEx(activity, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
			//请求成功回调

            }
        });

