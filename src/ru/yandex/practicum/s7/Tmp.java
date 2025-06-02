//package com.aditya.portlet;
//
//import com.aditya.constants.CustomFieldsPortletKeys;
//import com.liferay.expando.kernel.exception.NoSuchTableException;
//import com.liferay.expando.kernel.model.ExpandoBridge;
//import com.liferay.expando.kernel.model.ExpandoColumn;
//import com.liferay.expando.kernel.model.ExpandoColumnConstants;
//import com.liferay.expando.kernel.model.ExpandoTable;
//import com.liferay.expando.kernel.model.ExpandoTableConstants;
//import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
//import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
//import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.model.Group;
//import com.liferay.portal.kernel.model.ResourceConstants;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.role.RoleConstants;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//import com.liferay.portal.kernel.security.permission.ActionKeys;
//import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.UnicodeProperties;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.io.IOException;
//
//import javax.portlet.Portlet;
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author adit2
// */
//@Component(immediate = true, property = {"com.liferay.portlet.display-category=category.Liferay Is Easy", "com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true", "javax.portlet.display-name=CustomFields", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + CustomFieldsPortletKeys.CUSTOMFIELDS, "javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user"}, service = Portlet.class)
//public class CustomFieldsPortlet extends MVCPortlet {
//    @Override
//    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//        String first = "First field";//boolean
//        String second = "Second field";//String
//        String third = "Third field";// drop down with two        values like India, USA
//
//        long companyId = themeDisplay.getCompanyId();
//        String className = Group.class.getName(); // we create custom        fields in sites
//        String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
//        ExpandoTable expandoTable = addExpandoTable(companyId, className, tableName);
//
//        if (expandoTable != null) {
//            addExpandoTableForBoolean(companyId, className, tableName, first, expandoTable);
//            addExpandoTableForString(companyId, className, tableName, second, expandoTable);
//            addExpandoTableForDropDown(companyId, className, tableName, third, expandoTable);
//        }
//
//        super.doView(renderRequest, renderResponse);
//    }
//
//
//    private ExpandoColumn addExpandoTableForBoolean(long companyId, String className, String tableName, String columnName, ExpandoTable expandoTable) {
//        ExpandoColumn expandoColumn = null;
//        try {
//            expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
//            if (expandoColumn == null) {
//                expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), columnName, ExpandoColumnConstants.BOOLEAN, false);
//            }
//        } catch (PortalException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Expando column :"+expandoColumn.getColumnId());
//        setPermission(companyId, expandoColumn.getColumnId());
//        return expandoColumn;
//    }
//
//    private ExpandoColumn addExpandoTableForString(long companyId, String className, String tableName, String columnName, ExpandoTable expandoTable) {
//        ExpandoColumn expandoColumn = null;
//        try {
//            expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
//            if (expandoColumn == null) {
//                expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), columnName, ExpandoColumnConstants.STRING, StringPool.BLANK);
//            }
//        } catch (PortalException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Expando column :"+expandoColumn.getColumnId());
//        setPermission(companyId, expandoColumn.getColumnId());
//        return expandoColumn;
//    }
//
//    private ExpandoColumn addExpandoTableForDropDown(long companyId, String className, String tableName, String columnName, ExpandoTable expandoTable) {
//        ExpandoColumn expandoColumn = null;
//        try {
//            expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
//            if (expandoColumn == null) {
//                String[] object = new String[2];
//                object[0] = "India";
//                object[1] = "USA";
//
//                ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(companyId, className);
//                expandoBridge.addAttribute(columnName, ExpandoColumnConstants.STRING_ARRAY, object);
//
//                UnicodeProperties properties = new UnicodeProperties();
//                properties.setProperty(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE, ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST);
//
//                expandoBridge.setAttributeProperties(columnName, properties);
//
//                expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
//            }
//        } catch (PortalException e) {
//            e.printStackTrace();
//        }
//
//        setPermission(companyId, expandoColumn.getColumnId());
//        System.out.println("Expando column :"+expandoColumn.getColumnId()); return expandoColumn;
//
//    }
//
//    public ExpandoTable addExpandoTable(long companyId, String className, String tableName) {
//        ExpandoTable expandoTable = null;
//        try {
//            expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);
//        } catch (NoSuchTableException e) {
//            try {
//                expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId, className, tableName);
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return expandoTable;
//    }
//
//
//    public void setPermission(long companyId, long columnId) {
//        try {
//            Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.USER);
//            ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, ExpandoColumn.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(columnId), role.getRoleId(), new String[]{ActionKeys.VIEW, ActionKeys.UPDATE});
//        } catch (PortalException e) {
//            e.printStackTrace();
//        }
//    }
//}