package xml.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Log;
import android.util.Xml;

public class ParseXml {

	private URL feedUrl;

	private Entry _entry;
	
	final String RSS = "rss";
	final String CHANNEL = "channel";
	final String ITEM = "item";
	final String TITLE = "title";
	final String DESCRIPTION ="description";
	final String LINK ="link";
	final String PUBDATE ="pubDate";
	
	String tag = "xml parser";
	int i = 1;

	//

	public ParseXml(String feedUrlString) {
		try {
			// get url
			Log.i("URL: ", feedUrlString);
			this.feedUrl = new URL(feedUrlString);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	protected InputStream getInputStream() {
		try {
			return feedUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public ListEntry parseXMLHotel() {
		final ListEntry listItemEntry = new ListEntry();
		_entry = new Entry();

		RootElement root = new RootElement(RSS);
		// element root rss
		Element channel = root.getChild(CHANNEL);
		Element item = channel.getChild(ITEM);
		
		item.getChild(TITLE).setEndTextElementListener(
				new EndTextElementListener() {
					@Override
					public void end(String body) {
						Log.i(tag, "============//================");
						Log.i(tag, "item: " + i);
						i++;
						Log.i(tag, "Name: " + body);
						_entry.setTitle(body);
					}
				});
//		item.getChild(DESCRIPTION).setEndTextElementListener(
//				new EndTextElementListener() {
//					@Override
//					public void end(String body) {
//						Log.i(tag, "============//================");
//						Log.i(tag, "DESCRIPTION: " + body);
//						_entry.setDescription(body);
//					}
//				});
		item.getChild(PUBDATE).setEndTextElementListener(
				new EndTextElementListener() {
					@Override
					public void end(String body) {
						Log.i(tag, "============//================");
						Log.i(tag, "PUBDATE: " + body);
						_entry.setPubDate(body);
					}
				});
		item.getChild(LINK).setEndTextElementListener(
				new EndTextElementListener() {
					@Override
					public void end(String body) {
						Log.i(tag, "============//================");
						Log.i(tag, "LINK: " + body);
						_entry.setLink(body);
					}
				});
		item.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// copy tung item vao object Entry
				Log.i(tag, "============//================");
				Log.i(tag, "============Entry Copy================");
				listItemEntry.setListEntry(_entry.entryCopy());
			}
		});

		// get item entry
		root.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				Log.i(tag, "============//================");
				Log.i(tag, "============listEntryCopy================");
				// khi lay dc toan bo du lieu no se copy sang 1 list khac va du
				// lieu duoc xu ly tren du lieu tam nay
				listItemEntry.listEntryCopy();
			}
		});

		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8,
					root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listItemEntry;
	}
}
