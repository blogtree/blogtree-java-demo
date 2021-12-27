package org.blogtree.java.demo.springboot.bean.jquery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PostBeanListDto {

    private Integer id;

    private String name;


    /**
     * 测试入参包含 List<String>
     */
    private List<String> tags;

    /**
     * 测试入参包含 Bean
     */
    private PostBeanListChild child;

    /**
     * 测试入参包含 List<Bean>
     */
    private List<PostBeanListChild> children;

}
