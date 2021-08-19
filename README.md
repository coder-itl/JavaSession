###  JavaServlet

+ 注意事项`pom.xml`配置该项

  ```xml
  <build>
          <!-- 资源处理 -->
          <resources>
              <resource>
                  <!-- 所在目录 -->
                  <directory>src/main/java</directory>
                  <!-- 包括目录下的 .properties,.xml文件都会扫描到 -->
                  <includes>
                      <include>**/*.properties</include>
                      <include>**/*.xml</include>
                  </includes>
                  <!-- filtering 选项false 不启用过滤器,*.properties 已经起到过滤作用了  -->
                  <filtering>false</filtering>
              </resource>
          </resources>
      </build>
  ```

+ `database.properties`建立在`src/main/resources`文件夹下

  <img src="https://i.loli.net/2021/08/17/IveujCiJW4pFrS1.png" width="600">

+ `git`相关命令

  ```bash
  git remmote rm origin # 删除
  git remote set-url origin xxx
  
  git remote add origin xxx
  
  # 生成 ssh  ed25519.pub
  ssh-keygen -t ed25519 -C "941755602@qq.com"
  
  git rm -r --cached .
  
  git config --global http.proxy 'socks5://127.0.0.1:1080'
  git config --global https.proxy 'socks5://127.0.0.1:1080'
  
  ```
  
  

