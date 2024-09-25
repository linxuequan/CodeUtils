package Utils;
//import cn.hutool.json.JSONUtil;
//import com.hmdp.entity.Student;
//import com.hmdp.entity.Teacher;
//import com.hmdp.service.impl.StudentServiceImpl;
//import com.hmdp.service.impl.TeacherServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import javax.annotation.Resource;
//import java.util.function.Function;
//
//@SpringBootTest
//public class GenericsTest {
//    @Resource
//    private StudentServiceImpl studentService;
//    @Resource
//    private TeacherServiceImpl teacherService;
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    public <R, Search_field> R Cache_all_type(String preCache,Search_field field,Function<Search_field, R> select, Class<R> type){
//        // 存进Redis的某一类值统一前缀 + 查询字段（为区分，field一般为主键，例如id）
//        String key = preCache + field;
//        // 查询Redis缓存
//        String R_json = stringRedisTemplate.opsForValue().get(key);
//        if(R_json != null){
//            return JSONUtil.toBean(R_json, type);
//        }
//        // 未命中， 查询数据库并写入缓存
//        R r = select.apply(field);
//        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(r));
//        return r;
//    }
//    @Test
//    public void MMain(){
//        Student student  = Cache_all_type("Student:",1, id2->studentService.getById(id2), Student.class);
//
//        Teacher teacher  = Cache_all_type("Teacher:",1, id2->teacherService.getById(id2), Teacher.class);
//    }
//}
