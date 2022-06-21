/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 20.06.2022, 20:23:05                        ---
 * ----------------------------------------------------------------
 */
package com.integrationtool.jalo;

import com.integrationtool.constants.ZintegrationtoolConstants;
import com.integrationtool.jalo.ZProposedSolution;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>ZintegrationtoolManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedZintegrationtoolManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public ZProposedSolution createZProposedSolution(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZintegrationtoolConstants.TC.ZPROPOSEDSOLUTION );
			return (ZProposedSolution)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ZProposedSolution : "+e.getMessage(), 0 );
		}
	}
	
	public ZProposedSolution createZProposedSolution(final Map attributeValues)
	{
		return createZProposedSolution( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return ZintegrationtoolConstants.EXTENSIONNAME;
	}
	
}
