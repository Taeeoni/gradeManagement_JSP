package kr.ac.kopo.kopo11.domain;

public class Pagination {
	private int ppPage;
	private int pPage;
	private int npage;
	private int nnPage;
	private int cPage;
	private int countPerPage; // 페이지당 글 개수
	private int pageSize; // 한 화면에 선택가능한 페이지 개수
	private int totalCount;
	// 페이지 보여줄 시작 변수 pageStart -> pagination으로 옮긴다.
	// pageStart = ((Integer) (p.getcPage() - 1) / rowPage ) * rowPage + 1;
	private int pageStart;
	private int isLast;

	public int getIsLast() {
		return isLast;
	}

	public void setIsLast(int isLast) {
		this.isLast = isLast;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPpPage() {
		return ppPage;
	}

	public void setPpPage(int ppPage) {
		this.ppPage = ppPage;
	}

	public int getpPage() {
		return pPage;
	}

	public void setpPage(int pPage) {
		this.pPage = pPage;
	}

	public int getNpage() {
		return npage;
	}

	public void setNpage(int npage) {
		this.npage = npage;
	}

	public int getNnPage() {
		return nnPage;
	}

	public void setNnPage(int nnPage) {
		this.nnPage = nnPage;
	}

	public int getcPage() {
		return cPage;
	}

	public void setcPage(int cPage) {
		this.cPage = cPage;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
