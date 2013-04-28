package org.vinsert.component.debug;

import org.vinsert.bot.script.api.GameObject;
import org.vinsert.bot.script.api.Model;

import java.awt.*;


public class DebugObjectHulls extends ObjectDebugger {

    private Color color = new Color(255, 1, 1, 60);

    @Override
    public void draw(Graphics2D g) {
        for (GameObject obj : context.objects.getWithinDistance(5, getType())) {
            draw(g, obj, color);
        }
    }

    public void draw(Graphics2D g, GameObject obj, Color color) {
        Model model = obj.getModel();

        if (model == null || !model.isValid()) return;

        g.setColor(color);
        Polygon p = obj.hull();
        if (p != null) {
            g.fillPolygon(p);
        }
    }

}
