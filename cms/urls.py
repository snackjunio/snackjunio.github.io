from django.urls import path
from cms import views


app_name = 'cms'
urlpatterns = [
    # 本の一覧
    path('book/', views.book_list, name='book_list'),
    # 新しい本を追加
    path('book/add/', views.book_edit, name='book_add'),
    # 本を修正
    path('book/mod/<int:book_id>/', views.book_edit, name='book_mod'),
    # 本を削除
    path('book/del/<int:book_id>/', views.book_del, name='book_del'),
]
