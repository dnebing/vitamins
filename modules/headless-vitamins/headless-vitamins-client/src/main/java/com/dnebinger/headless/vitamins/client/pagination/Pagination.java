package com.dnebinger.headless.vitamins.client.pagination;

import javax.annotation.Generated;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
public class Pagination {

	public static Pagination of(int page, int pageSize) {
		return new Pagination(page, pageSize);
	}

	public int getEndPosition() {
		return _page * _pageSize;
	}

	public int getPage() {
		return _page;
	}

	public int getPageSize() {
		return _pageSize;
	}

	public int getStartPosition() {
		return (_page - 1) * _pageSize;
	}

	private Pagination(int page, int pageSize) {
		_page = page;
		_pageSize = pageSize;
	}

	private final int _page;
	private final int _pageSize;

}