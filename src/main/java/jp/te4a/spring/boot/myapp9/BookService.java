package jp.te4a.spring.boot.myapp9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
private static final BookBean Bean = null;
//	private static final BookBean BookBean = null;
	@Autowired
  	BookRepository bookRepository; 
  	public void create(BookForm bookForm) { //追加処理
  		
  		
  		BookBean bean = new BookBean();
//  		bean.setId(bookForm.getId());
//  		bean.setTitle(bookForm.getTitle());
//  		bean.setWritter(bookForm.getWritter());
//  		bean.setPublisher(bookForm.getPublisher());
//  		bean.setPrice(bookForm.getPrice());
  		
  		BeanUtils.copyProperties(bookForm, bean);
  		
//  	  BookBean bookBean = new BookBean();
//	  BeanUtils.copyProperties(bookForm, bookBean);
//bookRepository.savebookBean);
  		bookRepository.save(bean);
  	}

  	
  	public BookForm update(BookForm bookForm) { //更新処理
  	  BookBean Bean = new BookBean();
  	  BeanUtils.copyProperties(bookForm, Bean);
  	  //bookRepository.save(bookBean);
  	  //return bookForm;
  		
  		bookRepository.save(Bean);
  		return bookForm;
  		}
  	  
  	public void delete(Integer id) {//削除処理
  		bookRepository.deleteById(id); 
  		}
  	  
  	  public List<BookBean> findAll() {//取得処理
  	    List<BookBean> beanList = bookRepository.findAll();
  	    List<BookForm> formList = new ArrayList<BookForm>();
  	    
  	    for(BookBean Bean: beanList) {
  	      BookForm bookForm = new BookForm();
  	      BeanUtils.copyProperties(Bean, bookForm);
  	      formList.add(bookForm);
  	    }
  	    
  		return bookRepository.findAll();
  	    }
  	    
  	  public BookForm findOne(Integer id) {//取得処理
  	    Optional<BookBean> bookBean = bookRepository.findById(id);
  	  BookForm bookForm = new BookForm();
  	    bookBean.ifPresent(book ->{
  	  	BeanUtils.copyProperties(book, bookForm);
  	  	    
  	    });
  	  return bookForm;
  	  }
  	}