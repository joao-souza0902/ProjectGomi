/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.business;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Administrador
 */
public class WebPageOpener
{
    //Abre a pagina web
    public static boolean openWebpage(String site) throws URISyntaxException
    {
        URI uri = new URI(site);
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
        {
            try
            {
                desktop.browse(uri);
                return true;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
