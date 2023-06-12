package jp.te4a.spring.boot.myapp8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	private final ConcurrentMap<Integer, BookBean> bookMap
		= new ConcurrentHashMap<>();	

	private int BOOK_ID = 1;
		public int getBookId() {
			return BOOK_ID++;
	  }
	
	
	public BookBean create(BookBean bookBean) {//作成
		return bookMap.put(bookBean.getId(), bookBean);
	  }
	public BookBean update(BookBean updateBookBean) {//更新
		BookBean bookBean = bookMap.get(updateBookBean.getId());
		BeanUtils.copyProperties(updateBookBean, bookBean);
		return bookBean;
	}
	public void delete(Integer bookId) {//削除
		bookMap.remove(bookId);
	}
	public List<BookBean> findAll() {//一件/全件取得,
		return new ArrayList<>(bookMap.values());
	}
	public BookBean findOne(Integer id) {
		return bookMap.get(id);
	}
}
