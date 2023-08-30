package catalog_master_mgmt.model.repo;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import catalog_master_mgmt.model.master.ResourceCatalogReadMaster;

@Repository("resourceCatalogMasterReadRepo")
public class ResourceCatalogReadMasterRepo implements IResourceCatalogReadMasterRepo  
{
	private static final Logger logger = LoggerFactory.getLogger(ResourceCatalogReadMasterRepo.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
			
		public List<ResourceCatalogReadMaster> findAllForConditions(Integer parmLength, ArrayList<Long> cList, ArrayList<Long> rList, String catalog)
		{
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			String qryString = null;
			boolean cflag = false;
			boolean rflag = false;
			boolean caflag = false;
			
			if(parmLength==1)
			{
			if(cList!=null)
			{	
			qryString = "select * from resource_catalog_master where company_seq_no IN (:cList)";
			mapSqlParameterSource.addValue("cList", cList);
			}
			if(rList!=null)
			{
			qryString = "select * from resource_catalog_master where resource_catalog_seq_no IN (:rList)";
			mapSqlParameterSource.addValue("rList", rList);
			}
			if(catalog!=null)
			{
			qryString = "select * from resource_catalog_master where upper(trim(catalog)) = upper(trim(:catalog))";
			mapSqlParameterSource.addValue("catalog", catalog);
			}
			}
			
			if(parmLength>1)
			{
				if(cList!=null)
				{	
				qryString = "select * from resource_catalog_master where company_seq_no IN (:cList)";				
				mapSqlParameterSource.addValue("cList", cList);
				cflag=true;
				}
				else
				if(rList!=null)
				{
				qryString = "select * from resource_catalog_master where resource_catalog_seq_no IN (:rList)";				
				mapSqlParameterSource.addValue("rList", rList);
				rflag=true;
				}
				else
				if(catalog!=null)
				{
				qryString = "select * from resource_catalog_master where upper(trim(catalog)) = upper(trim(:catalog))";				
				mapSqlParameterSource.addValue("catalog", catalog);
				caflag=true;
				}
							
				for (int i = 1; i < parmLength; i++) 
				{
					if(cList!=null && !cflag)
					{	
					qryString = qryString+" or company_seq_no IN (:cList)";					
					mapSqlParameterSource.addValue("cList", cList);
					cflag=true;
					}
					else
					if(rList!=null  && !rflag)
					{
					qryString = qryString+" or resource_catalog_seq_no IN (:rList)";
					mapSqlParameterSource.addValue("rList", rList);
					rflag=true;
					}
					else
					if(catalog!=null && !caflag)
					{
					qryString = qryString+" or upper(trim(catalog)) = upper(trim(:catalog))";					
					mapSqlParameterSource.addValue("catalog", catalog);
					caflag=true;
					}
				  	
				}
				
			}
			
			 return namedParameterJdbcTemplate.query(
					 qryString,mapSqlParameterSource,
		                (rs, rowNum) ->
		                        new ResourceCatalogReadMaster(
		                                rs.getLong("resource_catalog_seq_no"),
		                                rs.getLong("company_seq_no"),
		                                rs.getString("catalog"),
		                                rs.getString("remark"),
		                                rs.getString("status")
		                        )
		        );
		
		}

		
		public List<ResourceCatalogReadMaster> findAll()
		{			
			 return jdbcTemplate.query(
					 "select * from resource_catalog_master",
		                (rs, rowNum) ->
		                        new ResourceCatalogReadMaster(
		                                rs.getLong("resource_catalog_seq_no"),
		                                rs.getLong("company_seq_no"),
		                                rs.getString("catalog"),
		                                rs.getString("remark"),
		                                rs.getString("status")
		                        )
		        );
		
		}

		
		public List<ResourceCatalogReadMaster> findByIdAndCompany(Long resSeqNo, Long compSeqNo)
	    {
			return null;	
	    }
	
}
