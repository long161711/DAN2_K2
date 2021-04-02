package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.configs.models.structures.AccountInfo;
import com.example.demo.configs.services.accountService1;
import com.example.demo.configs.services.accountroleService;
import com.example.demo.configs.services.roleService;
import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.AccountRoleEntity;
import com.example.demo.entities.RoleEntity;
//import com.example.demo.repositories.AccountRepository;
//import com.example.demo.repositories.AccountRoleRepository;
//import com.example.demo.repositories.RoleRepository;
import com.example.demo.utils.EncrytedPasswordUtils;
@Controller
public class DashboardController {
	private AccountInfo accountInfo;
//	@Autowired
//	RoleRepository roleRepository;
	@Autowired
	private roleService roleservice;
	@Autowired
	private accountService1 accountservice;
//	@Autowired
//	AccountRepository accountRepository;
	@Autowired
	accountroleService accountroleservice;
//	@Autowired
//	AccountRoleRepository accountRoleRepository;
    @GetMapping(value = "/dashboard")
    public String dashboard() {
        return "layouts/admin/pages/dashboard";
    }
    @GetMapping(value ="/hienthi" )
    public String hienthi(Model c) {
//	List<AccountEntity> aa = (List<AccountEntity>) this.accountRepository.findAll();
    List<AccountEntity> aa = accountservice.getAll();
    c.addAttribute("long", aa);
       	return "layouts/admin/fragments/hienthi";
    }
    @GetMapping(value = "/themaccount" )
    @PreAuthorize(value="hasAuthority('Administrator')")
    	public String them() {
    				return "layouts/admin/fragments/themaccount";
    }
    @PostMapping(value = "/themaccount")
    @PreAuthorize(value="hasAuthority('Administrator')")
    public String tt (@ModelAttribute AccountInfo accountInfo, ModelMap map) {
    	this.accountInfo=accountInfo;
    	System.out.println(accountInfo.getEmail());
//    	 AccountEntity kiemtra = accountRepository.findOneByEmail(accountInfo.getEmail());
    	 AccountEntity kiemtra = accountservice.findOneByEmail(accountInfo.getEmail());
		 if (kiemtra != null) {
	            return "403";
	        }
		 else {  
			 map.addAttribute("email",accountInfo.getEmail());
			 map.addAttribute("fullName",accountInfo.getFullName());			 
			 map.addAttribute("role",accountInfo.getRoleName());		
			 
			 return "layouts/admin/fragments/xacnhan";
		 }
    }
    @GetMapping(value = "/xacnhan")
    @PreAuthorize(value="hasAuthority('Administrator')")
	public String xacnhanlai(@RequestParam("nhapEmail") String email,
		    @RequestParam("nhapName") String fullName, @RequestParam("nhapRole") String role, Model model) {
		model.addAttribute("email", email);
		model.addAttribute("fullNama", fullName);
		model.addAttribute("role", role);
		return "layouts/admin/fragments/xacnhan";
	}
    @PostMapping(value = "/xacnhan")
   	public String xn (Model c) {
    		AccountEntity hihi = new AccountEntity();
    		hihi.setEmail(accountInfo.getEmail());
    		hihi.setEncrytedPassword(EncrytedPasswordUtils.encrytedPassword(accountInfo.getEncrytedPassword()));
    		hihi.setFullName( accountInfo.getFullName());
   			//accountRepository.save( new AccountEntity(accountInfo.getEmail(), EncrytedPasswordUtils.encrytedPassword(accountInfo.getEncrytedPassword()), accountInfo.getFullName()));
//    		accountRepository.save(hihi);
    		accountservice.save1(hihi);
//    		RoleEntity roleEntity = roleRepository.findOneByName(accountInfo.getRoleName());
    		RoleEntity roleEntity = roleservice.findOneByName(accountInfo.getRoleName());
//   	    AccountEntity accountEntity = accountRepository.findOneByEmail1(accountInfo.getEmail());
    		 AccountEntity accountEntity = accountservice.findOneByEmail1(accountInfo.getEmail());
    		AccountRoleEntity hoho= new AccountRoleEntity();
   	        hoho.setAccountId(accountEntity.getId());
   	        hoho.setRoleId(roleEntity.getId());
   	        //accountRoleRepository.save( new AccountRoleEntity(accountEntity.getId(), roleEntity.getId()));
//   	        accountRoleRepository.save(hoho);
   	        accountroleservice.save1(hoho);
//   	     List<AccountEntity> aa = (List<AccountEntity>) this.accountRepository.findAll();
   	        List<AccountEntity> aa = accountservice.getAll();
   	        c.addAttribute("long", aa);
   	        return "layouts/admin/fragments/hienthi";
   	}
    
}
