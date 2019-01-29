package controller.test;

import java.util.UUID;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller.test
 * @Author: yang
 * @CreateTime: 2019-01-23 16:51
 * @Description: ${Description}
 */
public class Testfile {
    public static void main(String args[]) {
        String pic_path = "F:\\java框架练习\\SSM\\picture";
        //上传图片的原始名称
        String oraginfilename = "dadegadadafadad.jpg";
        //新的图片名称
        String newfilename = UUID.randomUUID() + oraginfilename.substring(oraginfilename.lastIndexOf("."));

        System.out.println(newfilename);
        System.out.println(UUID.randomUUID());
        System.out.println(oraginfilename.substring(1,3));
    }
}
