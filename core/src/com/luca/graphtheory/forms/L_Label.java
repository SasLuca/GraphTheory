package com.luca.graphtheory.forms;

/**
 * Created by Sas on 11/9/2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.luca.graphtheory.GameScreen;
import com.luca.graphtheory.assets.L_Object;

public class L_Label extends L_Object
{

    protected       float               size;

    protected       BitmapFont          font;

    protected       Texture             distanceFieldTexture;

    protected       String              text                        = "";

    protected       String              fontName                    = "DEBUG_FONT";

    protected       GlyphLayout         layout                      = new GlyphLayout();

    protected       ShaderProgram       fontShader                  = new ShaderProgram(Gdx.files.internal("fonts/font.vert"), Gdx.files.internal("fonts/font.frag"));

    //region Constructors
    public L_Label(String text, String fontName, Color color, float size, Vector2 position)
    {

        this.text                                                   = text;

        this.fontName                                               = fontName;

        distanceFieldTexture                                        = new Texture(Gdx.files.internal("fonts/" + fontName + "/" + fontName + ".png"), true);

        distanceFieldTexture.                                       setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        this.font                                                   = new BitmapFont(Gdx.files.internal("fonts/" + fontName + "/" + fontName + ".fnt"), new TextureRegion(distanceFieldTexture), false);

        this.size                                                   = size;

        this.font.                                                  getData().setScale(size);

        this.font.                                                  setColor(color);

        layout.                                                     setText(this.font, text);

        this.position                                               = position;

        width                                                       = layout.width;

        height                                                      = layout.height;

    }

    public L_Label(String text, Color color, float size, Vector2 position)
    {

        this.text                                                   = text;

        distanceFieldTexture                                        = new Texture(Gdx.files.internal("fonts/" + fontName + "/" + fontName + ".png"), true);

        distanceFieldTexture.                                       setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        this.font                                                   = new BitmapFont(Gdx.files.internal("fonts/" + fontName + "/" + fontName + ".fnt"), new TextureRegion(distanceFieldTexture), false);

        this.size                                                   = size;

        this.font.                                                  getData().setScale(size);

        this.font.                                                  setColor(color);

        layout.                                                     setText(this.font, text);

        this.position                                               = position;

        width                                                       = layout.width;

        height                                                      = layout.height;

    }

    public L_Label()
    {



    }
    //endregion

    //region Methods
    @Override
    public void render()
    {

        GameScreen.                                                 getBatch().setShader(fontShader);

        //Draw text bottom to top instead of top to bottom
        font.                                                       draw(GameScreen.getBatch(), layout, position.x, position.y + height);

        GameScreen.                                                 getBatch().setShader(null);

    }

    @Override
    protected void topToBottomRendering()
    {

        GameScreen.                                                 getBatch().setShader(fontShader);

        //Draw text bottom to top instead of top to bottom
        //Text is by default being rendered top to bottom when using font.draw()
        //In TsunTsunLib we by default draw bottom to top so the default render() method for a text gets position.y + height as an argument to draw it bottom to top
        //But here we just pass the position as it is in order to render it top to bottom
        font.                                                       draw(GameScreen.getBatch(), layout, position.x, position.y);

        GameScreen.                                                 getBatch().setShader(null);

    }

    @Override
    protected void centerToPositionRendering()
    {

        GameScreen.                                                 getBatch().setShader(fontShader);

        //Draw text bottom to top instead of top to bottom
        //Text is by default being rendered top to bottom when using font.draw()
        //In TsunTsunLib we by default draw bottom to top so the default render() method for a text gets position.y + height / 2 as an argument to draw it bottom to top and center to position
        font.                                                       draw(GameScreen.getBatch(), layout, position.x - width / 2, position.y + height / 2);

        GameScreen.                                                 getBatch().setShader(null);

    }
    //endregion



    //region Getters and Setters
    public void setFont(String newFont)
    {

        this.fontName                                               = newFont;

        distanceFieldTexture                                        = new Texture(Gdx.files.internal("fonts/" + newFont + "/" + newFont + ".png"), true);

        this.font                                                   = new BitmapFont(Gdx.files.internal("fonts/" + newFont +"/" + newFont + ".fnt"), new TextureRegion(distanceFieldTexture), true);

        this.font.                                                  getData().setScale(size);

        this.font.                                                  setColor(color);

        layout.                                                     setText(this.font, text);

        width                                                       = layout.width;

        height                                                      = layout.height;

    }

    public void setText(String newText)
    {

        text                                                        = newText;

        layout.                                                     setText(this.font, text);

        width                                                       = layout.width;

        height                                                      = layout.height;

    }

    public void setSize(float newSize)
    {

        size                                                        = newSize;

        this.font.                                                  getData().setScale(newSize);

        this.                                                       setColor(color);

        layout.                                                     setText(this.font, text);

        width                                                       = layout.width;

        height                                                      = layout.height;

    }

    public float getSize()                                          { return size; }

    public String getText()                                         { return text; }
    //endregion

}
