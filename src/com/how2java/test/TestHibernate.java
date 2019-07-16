package com.how2java.test;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
import com.how2java.pojo.Category;
 
public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
 
        Session s = sf.openSession();
        s.beginTransaction();
        Category c = (Category) s.get(Category.class, 1);
 
        System.out.println("log1");
        System.out.println(c.getProducts());
        System.out.println("log1");
 
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}


/*package com.how2java.test;
  
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
import com.how2java.pojo.Product;
  
public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
  
        Session s = sf.openSession();
        s.beginTransaction();
     
        Product p = (Product)s.load(Product.class, 1);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2");
 
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
*/

/*
 * package com.how2java.test;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration; import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * Product p = (Product) s.get(Product.class, 1); s.delete(p);
 * 
 * Product p2 = (Product) s.get(Product.class, 2);
 * p2.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称"
 * ); s.update(p2);
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); } }
 */

/*
 * package com.how2java.test;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product; import com.how2java.pojo.User;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * // 增加3个用户 Set<User> users = new HashSet(); for (int i = 0; i < 3; i++) { User
 * u = new User(); u.setName("user" + i); users.add(u); s.save(u); }
 * 
 * // 产品1被用户1,2,3购买 Product p1 = (Product) s.get(Product.class, 1);
 * 
 * p1.setUsers(users); s.save(p1); s.getTransaction().commit(); s.close();
 * sf.close(); } }
 */

/*
 * package com.how2java.test;
 * 
 * import java.util.Set;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Category; import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * Category c = (Category) s.get(Category.class, 1); Set<Product> ps =
 * c.getProducts(); for (Product p : ps) { System.out.println(p.getName()); }
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); } }
 */

/*
 * package com.how2java.test;
 * 
 * import java.util.List;
 * 
 * import org.hibernate.Query; import org.hibernate.Session; import
 * org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * String name = "iphone";
 * 
 * String sql = "select * from product_ p where p.name like '%"+name+"%'";
 * 
 * Query q= s.createSQLQuery(sql); List<Object[]> list= q.list(); for (Object[]
 * os : list) { for (Object filed: os) { System.out.print(filed+"\t"); }
 * System.out.println(); }
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); } }
 */

/*
 * package com.how2java.test;
 * 
 * import java.util.List;
 * 
 * import org.hibernate.Criteria; import org.hibernate.Session; import
 * org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration; import
 * org.hibernate.criterion.Restrictions;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * String name = "iphone";
 * 
 * Criteria c= s.createCriteria(Product.class); c.add(Restrictions.like("name",
 * "%"+name+"%")); List<Product> ps = c.list(); for (Product p : ps) {
 * System.out.println(p.getName()); } s.getTransaction().commit(); s.close();
 * sf.close(); } }
 */

/*
 * package com.how2java.test;
 * 
 * import java.util.List;
 * 
 * import org.hibernate.Query; import org.hibernate.Session; import
 * org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * String name = "iphone"; Query q =s.createQuery(
 * "from Product p where p.name like ?"); q.setString(0, "%"+name+"%");
 * List<Product> ps= q.list(); for (Product p : ps) {
 * System.out.println(p.getName()); }
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); }
 * 
 * }
 */

/*
 * package com.how2java.test;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * Product p =(Product) s.get(Product.class, 6);
 * 
 * System.out.println(p.getName());
 * 
 * p.setName("iphone-modified");
 * 
 * s.update(p);
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); }
 * 
 * }
 */

/*
 * package com.how2java.test;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * 
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * Product p =(Product) s.get(Product.class, 5); s.delete(p);
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); }
 * 
 * }
 */

/*
 * package com.how2java.test;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * Product p = (Product) s.get(Product.class, 6);
 * 
 * System.out.println("id=6的产品名称是: " + p.getName());
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); }
 * 
 * }
 */

/*
 * package com.how2java.test;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate {
 *//**
	 * @param args
	 *//*
	 * public static void main(String[] args) {
	 * 
	 * SessionFactory sf = new
	 * Configuration().configure().buildSessionFactory();
	 * 
	 * Session s = sf.openSession(); s.beginTransaction(); Product p = new
	 * Product(); p.setName("p1"); System.out.println("此时p是瞬时状态"); s.save(p);
	 * System.out.println("此时p是持久状态"); s.getTransaction().commit(); s.close();
	 * System.out.println("此时p是脱管状态"); sf.close(); }
	 * 
	 * }
	 */

/*
 * package com.how2java.test;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration;
 * 
 * import com.how2java.pojo.Product;
 * 
 * public class TestHibernate { public static void main(String[] args) {
 * 
 * SessionFactory sf = new Configuration().configure().buildSessionFactory();
 * 
 * Session s = sf.openSession(); s.beginTransaction();
 * 
 * for (int i = 0; i < 10; i++) { Product p = new Product(); p.setName("iphone"
 * + i); p.setPrice(i); s.save(p); }
 * 
 * s.getTransaction().commit(); s.close(); sf.close(); }
 * 
 * }
 */