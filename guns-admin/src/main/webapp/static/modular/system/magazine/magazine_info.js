/**
 * 初始化通知详情对话框
 */
var MagazineInfoDlg = {
    MagazineInfoData: {},
    editor: null,
    validateFields: {
        title: {
            validators: {
                notEmpty: {
                    message: '标题不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
MagazineInfoDlg.clearData = function () {
    this.MagazineInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MagazineInfoDlg.set = function (key, value) {
    this.MagazineInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MagazineInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
MagazineInfoDlg.close = function () {
    parent.layer.close(window.parent.Magazine.layerIndex);
}

/**
 * 收集数据
 */
MagazineInfoDlg.collectData = function () {
    this.MagazineInfoData['content'] = MagazineInfoDlg.editor.txt.html();
    this.set('id').set('title');
}

/**
 * 验证数据是否为空
 */
MagazineInfoDlg.validate = function () {
    $('#magazineInfoForm').data("bootstrapValidator").resetForm();
    $('#magazineInfoForm').bootstrapValidator('validate');
    return $("#magazineInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加
 */
MagazineInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/magazine/add", function (data) {
        Feng.success("添加成功!");
        window.parent.Magazine.table.refresh();
        MagazineInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.noticeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
MagazineInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/magazine/update", function (data) {
        Feng.success("修改成功!");
        window.parent.Magazine.table.refresh();
        MagazineInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.noticeInfoData);
    ajax.start();
}

$(function () {
    Feng.initValidator("noticeInfoForm", MagazineInfoDlg.validateFields);

    //初始化编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();
    editor.txt.html($("#contentVal").val());
    NoticeInfoDlg.editor = editor;
});
