package com.stylefeng.guns.generator.action.config;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 默认的代码生成的配置
 *
 * @author fengshuonan
 * @date 2017-10-28-下午8:27
 */
public class GunsGeneratorConfig extends AbstractGeneratorConfig {

    protected void globalConfig() {
        globalConfig.setOutputDir("/Users/yushuai/Desktop");//写自己项目的绝对路径,注意具体到java目录
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("codeGenerator");
    }

    protected void dataSourceConfig() {
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("uAiqwVwjJ8-i");
        dataSourceConfig.setUrl("jdbc:mysql://39.108.239.82:3306/guns?characterEncoding=utf8");
    }

    protected void strategyConfig() {
        //strategyConfig.setTablePrefix(new String[]{"wx_user"});// 此处可以修改为您的表前缀
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(new String[]{"wx_user"});
    }

    protected void packageConfig() {
        packageConfig.setParent(null);
        packageConfig.setEntity("com.stylefeng.guns.admin.common.persistence.model");
        packageConfig.setMapper("com.stylefeng.guns.admin.common.persistence.dao");
        packageConfig.setXml("com.stylefeng.guns.admin.common.persistence.dao.mapping");
    }

    protected void contextConfig() {
        contextConfig.setProPackage("com.stylefeng.guns.admin");
        contextConfig.setCoreBasePackage("com.stylefeng.guns.core");
        contextConfig.setBizChName("微信用户管理");
        contextConfig.setBizEnName("wxUser");
        contextConfig.setModuleName("wxUser");
        contextConfig.setProjectPath("/Users/yushuai/Desktop");//写自己项目的绝对路径
        contextConfig.setEntityName("WxUser");
        sqlConfig.setParentMenuName(null);//这里写已有菜单的名称,当做父节点

        /**
         * mybatis-plus 生成器开关
         */
        contextConfig.setEntitySwitch(true);
        contextConfig.setDaoSwitch(true);
        contextConfig.setServiceSwitch(true);

        /**
         * guns 生成器开关
         */
        contextConfig.setControllerSwitch(true);
        contextConfig.setIndexPageSwitch(true);
        contextConfig.setAddPageSwitch(true);
        contextConfig.setEditPageSwitch(true);
        contextConfig.setJsSwitch(true);
        contextConfig.setInfoJsSwitch(true);
        contextConfig.setSqlSwitch(true);
    }

    @Override
    protected void config() {
        globalConfig();
        dataSourceConfig();
        strategyConfig();
        packageConfig();
        contextConfig();
    }
}
