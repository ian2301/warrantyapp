# 引入 jdk 8
FROM amazoncorretto:17

# author
MAINTAINER IAN

# VOLUME 指定了临时文件目录为/tmp
VOLUME /tmp

#  jar file 将当前路径下的jar文件, 映射到容器路径下
ADD ./warrantyapp.jar ./warrantyapp.jar

# 暴露8080端口 该项目后端的端口为8080
EXPOSE 5050

#   jar
RUN bash -c 'touch /warrantyapp.jar'

# 入口注意指定配置文件=prod
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/warrantyapp.jar"]
