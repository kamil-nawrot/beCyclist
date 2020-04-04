import {Component, OnInit} from '@angular/core';
import IEvent from '../../models/event';
import {SearchService} from '../../services/search.service';

@Component({
  selector: 'app-results-grid',
  templateUrl: './results-grid.component.html',
  styleUrls: ['./results-grid.component.css']
})
export class ResultsGridComponent implements OnInit {

  public searchResults: IEvent[];
  public queryParams: {};

  constructor(private searchService: SearchService) {
  }

  ngOnInit(): void {
    this.searchResults = this.searchService.searchResults;
    this.queryParams = this.searchService.queryParams;
  }

}
