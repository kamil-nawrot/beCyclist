import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {SearchService} from '../../services/search.service';

import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';

import * as _moment from 'moment';
import {Router} from '@angular/router';

const moment = _moment;

export const DATE_FORMATS = {
  parse: {
    date: 'DD/MM/YYYY'
  },
  display: {
    dateInput: 'LL',
    monthYearLabel: 'M YYYY',
    dateA11yLabel: 'LL',
  }
};

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css'],
  providers: [
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: DATE_FORMATS},
  ]
})
export class SearchFormComponent implements OnInit {

  searchForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private searchService: SearchService, private router: Router) {
    this.searchForm = this.formBuilder.group({
      name: null,
      dateFrom: null,
      dateTo: null
    });
  }

  ngOnInit(): void {
  }

  submitForm() {
    this.searchService.getAllEvents(this.searchForm.value)
      .subscribe(response => {
        this.searchService.searchResults = response;
        this.router.navigateByUrl('/results');
      });
  }

}
